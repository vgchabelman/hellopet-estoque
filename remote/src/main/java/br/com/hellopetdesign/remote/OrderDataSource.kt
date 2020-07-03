package br.com.hellopetdesign.remote

import br.com.hellopetdesign.data.datasource.IOrderDataSource
import br.com.hellopetdesign.remote.dtos.OrdersDTO
import br.com.hellopetdesign.domain.model.Order
import br.com.hellopetdesign.domain.model.OrderProduct
import kotlinx.coroutines.tasks.await

class OrderDataSource(private val firebaseRemote: FirebaseRemote) : IOrderDataSource {
    override suspend fun getAllOrders(): List<Order> {
        val querySnapshot = firebaseRemote.getOrderCollection()
            .get()
            .await()

        return querySnapshot.toObjects(OrdersDTO::class.java).map {
            val pList: List<OrderProduct> = it.products.map { map ->
                OrderProduct(
                    productId = map["productId"],
                    quantity = map["quantity"] ?: 1
                )
            }
            Order(
                orderId = it.id.toInt(),
                client = it.client,
                shippingDate = it.shippingDate,
                productList = pList
            )
        }
    }
}