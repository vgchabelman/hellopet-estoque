package br.com.hellopetdesign.presentation.model

data class Product(
    val productId: Long,
    var name: String,
    var materials: List<ProductMaterial>
)