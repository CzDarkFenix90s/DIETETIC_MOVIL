import { IsString, IsNotEmpty, IsOptional } from 'class-validator';

export class CreateUserDto {
  @IsString()
  @IsNotEmpty()
  username: string;
  
  @IsString()
  @IsOptional()
  content: string;

  @IsString()
  @IsNotEmpty()
  password: string;
}
