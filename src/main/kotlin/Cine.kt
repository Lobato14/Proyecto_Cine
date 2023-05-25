import java.io.File

class Cine {
    private val nFilas = 10
    private val nAsientos = 15
    private val nombreCine = "Cine Club Lumiere"
    private val cine = Array(nFilas) { BooleanArray(nAsientos) }

    // Realizamos un bucle para el numero de filas y asientos que por defecto estará vacía
    init {
        // Al crear el cine, todos los asientos están libres
        for (i in 0 until nFilas) {
            for (j in 0 until nAsientos) {
                cine[i][j] = false
            }
        }
    }
    // Función que muestra el cine
    fun mostrarCine() {
        println("-------------------------")
        println("Cine Club Lumiere")
        for (i in 0 until nFilas) {
            println("fila: $i")
            for (j in 0 until nAsientos) {
                if (cine[i][j]) {
                    print("XX")
                } else {
                    print("__")
                }
                print("  ")
            }
            println()
        }
        println("-------------------------")
    }
    // Función para vender una entrada
    fun comprarEntrada(fila: Int, asiento: Int): Boolean {
        if (fila in 0 until nFilas && asiento in 0 until nAsientos) {
            if (cine[fila][asiento]) {
                println("La entrada para la fila $fila, asiento $asiento ya está vendida.")
                return false
            } else {
                cine[fila][asiento] = true
                println("Has comprado la entrada para la fila $fila, asiento $asiento.")
                return true
            }
        } else {
            println("Fila o asiento inválido.")
            return false
        }
    }
    // Función para devolver la entrada
    fun devolverEntrada(fila: Int, asiento: Int): Boolean {
        if (fila in 0 until nFilas && asiento in 0 until nAsientos) {
            if (!cine[fila][asiento]) {
                println("La entrada para la fila $fila, asiento $asiento no está vendida.")
                return false
            } else {
                cine[fila][asiento] = false
                println("Has devuelto la entrada para la fila $fila, asiento $asiento.")
                return true
            }
        } else {
            println("Fila o asiento inválido.")
            return false
        }
    }
    // Función para leer las ventas actuales
    fun leerVentas() {
        val file = File("src/entradasVendidas.txt")
        if (file.exists()) {
            val ventas = file.readLines()
            for (venta in ventas) {
                val (fila, asiento) = venta.split(":")
                cine[fila.toInt()][asiento.toInt()] = true
            }
        }
    }
    // Funcion para guardar las ventas
    fun guardarVentas() {
        val file = File("src/entradasVendidas.txt")
        val ventas = mutableListOf<String>()
        for (i in 0 until nFilas) {
            for (j in 0 until nAsientos) {
                if (cine[i][j]) {
                    ventas.add("-------$nombreCine----------\n" +
                            "-----------Fila: $i--------\n " +
                            "-----------Asiento: $j------\n" +
                            "------------------------------------")
                }
            }
        }
        file.writeText(ventas.joinToString("\n"))
    }
}

