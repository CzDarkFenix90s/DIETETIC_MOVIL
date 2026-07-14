// lib/data/remote/interceptor/auth_interceptor.dart

import 'package:dio/dio.dart';
import '../../local/secure_storage.dart';

class AuthInterceptor extends Interceptor {
  final SecureStorage _storage;
  final Dio _dio;

  AuthInterceptor(this._storage, this._dio);

  @override
  void onRequest(
    RequestOptions options,
    RequestInterceptorHandler handler,
  ) async {
    // 1. REGLA DE ORO DIO: Si el path empieza con /, ignora el baseUrl.
    // Normalizamos para asegurar que use el baseUrl (/api/)
    if (options.path.startsWith('/') && !options.path.startsWith('http')) {
      options.path = options.path.substring(1);
    }

    // 2. Adjuntar Token si existe
    final token = await _storage.getAccess();
    if (token != null && token.isNotEmpty) {
      options.headers['Authorization'] = 'Bearer $token';
    }
    
    // DEBUG: Imprimir headers en modo desarrollo si falla
    // print('REQUEST: ${options.method} ${options.uri}');
    // print('HEADERS: ${options.headers}');

    handler.next(options);
  }

  @override
  void onError(DioException err, ErrorInterceptorHandler handler) async {
    final response = err.response;

    // Si no es 401, no nos corresponde
    if (response?.statusCode != 401) {
      handler.next(err);
      return;
    }
    
    // Evitar bucles infinitos en el refresh
    final path = err.requestOptions.path;
    if (path.contains('auth/token/refresh')) {
      await _storage.clearSession();
      handler.next(err);
      return;
    }
    
    if (err.requestOptions.extra['_retry'] == true) {
      await _storage.clearSession();
      handler.next(err);
      return;
    }

    final refresh = await _storage.getRefresh();
    if (refresh == null || refresh.isEmpty) {
      // Si no hay refresh token, no podemos hacer nada
      // Solo limpiamos si el error indica que es por falta de credenciales
      // pero el usuario cree que está logueado
      handler.next(err);
      return;
    }

    try {
      final refreshResponse = await _dio.post(
        'auth/token/refresh/',
        data: {'refresh': refresh},
        options: Options(extra: {'_retry': true}),
      );

      final newAccess = refreshResponse.data['access'] as String;
      final newRefresh = refreshResponse.data['refresh'] as String?;

      await _storage.saveAccessToken(newAccess);
      if (newRefresh != null) {
        await _storage.saveTokens(newAccess, newRefresh);
      }

      final retryOptions = err.requestOptions;
      retryOptions.headers['Authorization'] = 'Bearer $newAccess';
      retryOptions.extra['_retry'] = true;

      final retryResponse = await _dio.fetch(retryOptions);
      handler.resolve(retryResponse);
    } on DioException {
      await _storage.clearSession();
      handler.next(err);
    }
  }
}
