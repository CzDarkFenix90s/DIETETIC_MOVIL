import {Test, TestingModule} from '@nestjs/testing';
import { AppService } from './app.service';

describe('AppService',() => {
    let service: AppService;

    beforeEach(async () => {
        const module: TestingModule = await Test.createTestingModule({
            providers: [AppService],
        }).compile();
        service = module.get<AppService>(AppService);
    });

    it('deberia estar definido', () => {
        expect(service).toBeDefined();
    });

    it('getHello() deberia retornar el mensaje esperado', () => {
        expect(service.getHello()).toBe(
            'Hello World desde los poderosos programadores del tercer semestre',
        );
    });

    it('getHello() deberia retornar un string no vacio', () => {
        const result = service.getHello();
        expect(typeof result).toBe('string');
        expect(result.length).toBeGreaterThan(0);
    });
});