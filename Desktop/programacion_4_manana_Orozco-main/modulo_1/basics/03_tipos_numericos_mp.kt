fun main() {
    // Tipos Datos
    // Numeros Enteros
    val numero1: Byte=127
    println("Numero Byte $numero1")
    val numero2: Short=32_765
    println("Numero Short $numero2")
    val numero3: Int=12
    println("Numero Int $numero3")
    val numero4: Long=12_122_122_122_123_123L
    println("Numero Long $numero4")
    println("Numeros decimales")
    val numero5: Float=3.14f
    println("Numero Float $numero5")
    val numero6: Double=3.14159265
    println("Numero Double $numero6")
    //Inferido
    val nombre="Juan"
    val edad=22
    println("Nombre $nombre")
    val nombreTipo=nombre::class.simpleName
    println("Tipo inferido nombre: ${nombre::class.simpleName}")
    println("Tipo inferido nombre: ${nombreTipo}")
    val edadTipo=edad::class.simpleName
    println("Edad: $edad")
    println("Tipo inferido edad: ${edad::class.simpleName}")
    println("Tipo inferido edad: ${edadTipo}")
}