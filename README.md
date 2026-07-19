# Dietetic App - Gestión Nutricional Inteligente

Desarrollo de una aplicación móvil integral en Flutter que consume una API REST desarrollada en Django. El sistema implementa una sección pública y una sección privada protegida por autenticación robusta y control de acceso basado en roles (ADMIN, NUTRICIONISTA, PACIENTE).

## 🚀 Objetivos del Proyecto

*   **Interfaz Pública:** Navegación fluida y pantallas informativas para usuarios no registrados.
*   **Autenticación Segura:** Manejo de sesiones mediante JWT (JSON Web Tokens) con almacenamiento persistente.
*   **Control de Acceso (RBAC):** Restricción de funcionalidades según el rol del usuario:
    *   **ADMIN:** Gestión total de usuarios, categorías, recetas y reportes globales.
    *   **NUTRICIONISTA:** Creación de planes nutricionales, seguimiento de evolución y gestión de agenda.
    *   **PACIENTE:** Visualización de dieta diaria, registro de rutinas de ejercicio, seguimiento de logros y chat.
*   **Consumo de API:** Integración completa de endpoints para operaciones CRUD en módulos de Alimentos, Recetas, Planes y Evaluación Antropométrica.

## 📁 Estructura del Proyecto (Clean Architecture)

Siguiendo las mejores prácticas de organización y escalabilidad:

```text
lib/
├── main.dart
├── core/
│   ├── config/          # Configuración global (URL base)
│   ├── error/           # Manejo centralizado de errores (api_exception.dart)
│   └── utils/           # Validadores de formularios y formateadores
├── data/
│   ├── remote/
│   │   ├── api/         # Dio Client + Auth Interceptors
│   │   └── dto/         # Data Transfer Objects (plan_dto, user_dto)
│   ├── local/           # Persistencia (Secure Storage / SharedPreferences)
│   └── repository/      # Implementación de repositorios (patient_repository_impl.dart)
├── domain/
│   ├── model/           # Modelos de datos (Alimento, RutinaEjercicio, PlanNutricional)
│   └── repository/      # Definición de interfaces de repositorio
├── presentation/
│   ├── navigation/      # GoRouter con Guards de protección por rol
│   ├── providers/       # Gestión de estado (Riverpod: auth_provider, patient_provider)
│   ├── screens/
│   │   ├── auth/        # Login, Registro, Recuperación de contraseña y Perfil
│   │   ├── patient/     # Plan Semanal, Progreso, Catálogo de Planes y Chat
│   │   ├── admin/       # Dashboard, Gestión de Recetas, Usuarios y Nutricionistas
│   │   └── nutri/       # Agenda de citas y Seguimiento de pacientes
│   ├── widgets/         # UI Components (CustomAppBar, MealCards, SearchBar)
│   └── theme/           # Identidad visual (app_colors.dart, app_theme.dart)
```

## 🛠️ Requerimientos Mínimos Obligatorios

1.  **Navegación Protegida:** Uso de `GoRouter` para impedir el acceso a rutas privadas sin un token válido.
2.  **Manejo de Roles:** Interfaz adaptativa que oculta o bloquea acciones según el rol detectado en el perfil del usuario.
3.  **Consumo Real de API:** CRUD funcional conectado a backend Django (no se usan datos mock).
4.  **UX/UI Avanzada:**
    *   Indicadores de carga (`CircularProgressIndicator`).
    *   Feedback al usuario mediante `SnackBar` y `Dialogs`.
    *   Soporte para "Pull-to-Refresh" en listados dinámicos.

## ⚙️ Instalación y Configuración

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/alexis/dietetic_flutter.git
    ```
2.  **Instalar dependencias:**
    ```bash
    flutter pub get
    ```
3.  **Configurar Variables:** Asegurarse de que la URL base en el `DioClient` apunte a la dirección correcta del servidor.
4.  **Ejecutar:**
    ```bash
    flutter run
    ```

## 🔐 Credenciales de Prueba (Demo)
*   **Administrador:** `admin1` / `admin12345`
*   **Nutricionista:** `pablo` / `pablo12345`
*   **Paciente:** `dio` / `dio12345`
