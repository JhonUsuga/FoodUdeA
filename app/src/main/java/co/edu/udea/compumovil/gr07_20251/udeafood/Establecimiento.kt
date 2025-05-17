package co.edu.udea.compumovil.gr07_20251.udeafood

data class Establecimiento(
    val id: String,
    val nombre: String,
    val ubicacion: String,
    val estado: String,
    val puntuacion: Double,
    val precioMinimo: Double,
    val logo: Int
)
