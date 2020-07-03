package br.com.hellopetdesign.domain.model

data class Product(
    var productId: Long,
    var name: String,
    var materials: List<ProductMaterial>,
    val inventory: Int
)