package br.com.hellopetdesign.domain.model

data class OrderProduct(
    var product: Product? = null,
    var productId: Int? = null,
    var quantity: Int
)