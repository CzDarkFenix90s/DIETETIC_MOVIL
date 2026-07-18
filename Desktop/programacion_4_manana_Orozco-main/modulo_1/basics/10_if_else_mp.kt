fun main() {
  println("Controles de Flujo")
  println("Condicional IF - else")
  println("Tipo de sacramiento: (bautizo o confesion)")
  val tipo = readLine()?.trim()?.trim()?.lowercase()=="bautizo"
  if(tipo){
      println("Tiene que bautizarse")
  } else {
      println("Tiene que confesarse") 
  }
}