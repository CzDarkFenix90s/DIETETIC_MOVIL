fun main() {
  println("Controles de Flujo")
  println("Condicional IF")
  println("Incluir Edad para el sacramiento: ")
  val edad = readLine()?.toDoubleOrNull()?: 36
  if(edad>=18){
      println("Mayor de edad")
  } 
  if(edad<=17){
    println("Menor de edad")
  }
  println("Edad registrada: $edad") 
}