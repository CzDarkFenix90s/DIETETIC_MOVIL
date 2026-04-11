fun main() {
  println("Controles de Flujo")
  println("Condicional IF - Anidado")
  println("Estado:")
  val tieneAntecedentes = readLine()?.trim()?.lowercase()=="en curso"
  println("Minutos transcurridos: ")
  val frecuencia = readLine()?.toIntOrNull()?:0
  if(tieneAntecedentes){
    if (frecuencia>30) {
    println("Consulta Extendida")
  } else {
    println("No supera el tiempo")
  }
  }
}