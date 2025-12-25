import { Controller, Get, Param , Post , Body, Put, Delete} from '@nestjs/common';
import { BasicsService } from './basics.service';

@Controller('basics')
export class BasicsController {
    constructor(private readonly basicsService: BasicsService) {}

     @Get()
     getMyFirstGet(): object {
        return this.basicsService.getMyFirstGet();
      }
     @Get(':parametro')
     getConParametros(@Param('parametro') parametro: string) {
         return this.basicsService.getConParametros(parametro);
      } 
     @Post()
     create(@Body() bodyPost: object) {
         return this.basicsService.postFunction(bodyPost);
      }   
     @Put(':id')
     update(@Body('id') bodyPost: object, @Param('id') id: string) {
         return this.basicsService.putFunction(bodyPost, id);
      }  
     @Delete(':id')
     delete(@Param('id') id: string) {
         return this.basicsService.deleteFunction(id); 
    }
     @Post('calculo-area-triangulo')
     calculotriangulo(@Body() bodyPost: object) {
         return this.basicsService.calculotriangulo(bodyPost);
    }
     @Get('calculo-area-rectangulo/:ancho/:alto')
     areaRectangulo(   
     @Param('ancho') ancho: number,
     @Param('alto') alto: number,
    ){
         return this.basicsService.areaRectangulo(ancho, alto);    
    }
}

