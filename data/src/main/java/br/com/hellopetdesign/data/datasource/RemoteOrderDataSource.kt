package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.data.remote.FirebaseRemote
import br.com.hellopetdesign.data.remote.dtos.OrdersDTO
import br.com.hellopetdesign.domain.model.Order
import br.com.hellopetdesign.domain.model.OrderProduct
import kotlinx.coroutines.tasks.await

class RemoteOrderDataSource(private val firebaseRemote: FirebaseRemote) : IOrderDataSource {
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