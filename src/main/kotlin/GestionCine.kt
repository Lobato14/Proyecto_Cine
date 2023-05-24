class GestionCine {
    private val cine: Cine

    init {
        cine = Cine()
        cine.leerVentas()
        mostrarMenu()
    }

    private fun mostrarMenu() {
        var opcion: Int
        do {
            println("1. Mostrar butacas")
            println("2. Comprar entrada")
            println("3. Devolver una entrada")
            println("4. Salir")
            println("-------------------------")

            opcion = readLine()?.toIntOrNull() ?: 0

            when (opcion) {
                1 -> cine.mostrarCine()
                2 -> comprarEntrada()
                3 -> devolverEntrada()
                4 -> {
                    cine.guardarVentas()
                    println("Saliendo de la aplicación...")
                }
                else -> println("Opción inválida. Por favor, selecciona una opción válida.")
            }
        } while (opcion != 4)
    }

    private fun comprarEntrada() {
        println("Introduce el número de fila:")
        val fila = readLine()?.toIntOrNull()
        println("Introduce el número de asiento:")
        val asiento = readLine()?.toIntOrNull()

        if (fila != null && asiento != null) {
            cine.venderEntrada(fila, asiento)
        } else {
            println("Valores de fila o asiento inválidos.")
        }
    }

    private fun devolverEntrada() {
        println("Introduce el número de fila:")
        val fila = readLine()?.toIntOrNull()
        println("Introduce el número de asiento:")
        val asiento = readLine()?.toIntOrNull()

        if (fila != null && asiento != null) {
            cine.devolverEntrada(fila, asiento)
        } else {
            println("Valores de fila o asiento inválidos.")
        }
    }
}