fun main() {
  println("Controles de Flujo")
  println("Condicional IF - Anidado")
  println("Tiene antecedentes cardiacos?")
  val tieneAntecedentes = readLine()?.trim()?.lowercase()=="s"
  println("Frecuencia Cardiaca (lpm)")
  val frecuencia = readLine()?.toIntOrNull()?:0
  if(tieneAntecedentes){
      println("Paciente con antecedentes cardiacos")
      if(frecuencia<50) {
          println("Bradicardia severa")
      } else if(frecuencia>100){
          println("Taquicardia")
      } else {
          println("Frecuencia Normal")
      }
  } else {
      println("Paciente sin antecedentes cardiacos")
      if(frecuencia<50 || frecuencia > 100) {
          println("Frecuencia fuera del rango normal")
      } else {
          println("Frecuencia Cardiaca Normal")
      }
  }
}