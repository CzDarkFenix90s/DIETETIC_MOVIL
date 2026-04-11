fun main() {
    val nombre="Alan"
    val apellido="Kennedy"
    val edad=28
    // variable simple
    println("Hola $nombre")
    //Expresion
    println("Nombre Completo: ${nombre.uppercase()} ${apellido.uppercase()}")
    val nombreCompleto = "Nombre Completo: ${nombre.uppercase()} ${apellido.uppercase()}"
    println(nombreCompleto)
    println("Edad: ${edad+5} años")
    //String Multilinea
    val tarjeta = """
        |Nombre: $nombre $apellido
        |Edad: $edad
        |Acceso: ${if(edad>=18)"Permitido el ingreso al sacramiento" else "Denegado el ingreso al sacramiento"}"""
    println(tarjeta)
}