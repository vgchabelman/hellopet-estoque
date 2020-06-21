package br.com.hellopetdesign.domain.model

data class Product(
    val productId: Long,
    var name: String,
    var materials: List<ProductMaterial>
)