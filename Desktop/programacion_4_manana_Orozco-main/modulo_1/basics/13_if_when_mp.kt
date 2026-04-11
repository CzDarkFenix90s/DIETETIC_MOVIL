fun main() {
  println("Controles de Flujo When")
  println("Escriba codigo")
  val codigo = readLine()?.toIntOrNull()?:0
  val especialidad = when(codigo){
      1->"Bautismo"
      2->"Confirmacion"
      3->"Confesion"
      4->"Orden sacerdotal"
      5->"Matrimonio"
      6->"Uncion de los enfermos"
      else ->"Especialidad no registrada en el sistema"
  }
  println("Especialidad: $especialidad")
}