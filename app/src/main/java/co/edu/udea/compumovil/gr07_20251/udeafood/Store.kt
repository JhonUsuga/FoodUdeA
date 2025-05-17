package co.edu.udea.compumovil.gr07_20251.udeafood

import java.util.UUID

data class Store (
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val location: String,
    val open: Boolean,
    val hours: String,
    val minPrice: Int,
    val imageResId: Int,
    val products: MutableList<Product> = mutableListOf()
)