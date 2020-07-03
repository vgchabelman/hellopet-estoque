package br.com.hellopetdesign.domain.model

import java.util.*

data class Order(
    var orderId: Int,
    var client: String,
    val shippingDate: Date,
    val productList: List<OrderProduct>
)