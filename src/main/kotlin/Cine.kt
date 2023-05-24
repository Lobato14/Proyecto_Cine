class Cine {
    private val nFilas = 10
    private val nAsientos = 15
    private val nombreCine = "Cine Club Lumiere"
    private val cine = Array(nFilas) { BooleanArray(nAsientos) }

    init {
        // Al crear el cine, todos los asientos están libres
        for (i in 0 until nFilas) {
            for (j in 0 until nAsientos) {
                cine[i][j] = false
            }
        }
    }
}