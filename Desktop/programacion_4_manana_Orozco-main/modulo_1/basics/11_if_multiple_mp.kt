fun main() {
  println("Controles de Flujo")
  println("Condicional IF - Multiples condiciones")
  println("Tipo de sacramiento por edad")
  val sacramiento = readLine()?.toIntOrNull()?:0
  
  val clasificacion = if(sacramiento<=2){
      "Bautizo"
  } else if(sacramiento<=10){
      "Confirmacion"
  } else if(sacramiento<=18){
      "Confesion"
  } else if(sacramiento<=30){
      "Matrimonio"
  } else if(sacramiento<=40){
      "Orden sacerdotal"
  } else {
      "Uncion de los enfermos"
  }
  println("Clasificacion: $clasificacion")
  println("Clasificacion: ${clasificacion.uppercase()}")
}