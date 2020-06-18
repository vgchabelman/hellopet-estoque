package br.com.hellopetdesign.data.models

data class Product(
    var productId: Long,
    var name: String,
    var materials: List<ProductMaterial>
)