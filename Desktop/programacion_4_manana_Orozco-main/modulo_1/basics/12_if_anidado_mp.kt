fun main() {
  println("Controles de Flujo")
  println("Condicional IF - Anidado")
  println("Estado:")
  val tieneAntecedentes = readLine()?.trim()?.lowercase()=="sacramiento"
  println("Minutos transcurridos: ")
  val frecuencia = readLine()?.toIntOrNull()?:0
  if(tieneAntecedentes){
    if (frecuencia>100) {
    println("Sacramiento cumplido")
  } else {
    println("No tiene el tiempo cumplido")
  }
  }
}