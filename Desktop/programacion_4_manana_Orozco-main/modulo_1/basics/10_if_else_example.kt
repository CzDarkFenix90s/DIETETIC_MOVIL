fun main() {
  println("Controles de Flujo")
  println("Condicional IF - else")
  println("Tipo de examen: (laboratorio o imagen)")
  val tipoExamen = readLine()?.trim()?.trim()?.lowercase()=="laboratorio"
  if(tipoExamen){
      println("Tiene que ir en ayuna")
  } else {
      println("No importa si va en ayuna") 
  }
}