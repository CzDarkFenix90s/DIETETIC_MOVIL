fun main() {
  println("Controles de Flujo")
  println("Condicional IF - Multiples condiciones")
  println("Presion sistolica mmHg")
  val sistolica = readLine()?.toIntOrNull()?:0
  
  val clasificacion = if(sistolica<=90){
      "Hipotension"
  } else if(sistolica<=119){
      "Normal"
  } else if(sistolica<=129){
      "Elevada"
  } else if(sistolica<=139){
      "Hipertension Grado 1"
  } else if(sistolica<=179){
      "Hipertension Grado 2"
  } else {
      "Crisis Hipertensiva"
  }
  println("Clasificacion: $clasificacion")
  println("Clasificacion: ${clasificacion.uppercase()}")
}