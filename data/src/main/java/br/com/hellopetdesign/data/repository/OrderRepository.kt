package br.com.hellopetdesign.data.repository

import br.com.hellopetdesign.data.datasource.IOrderDataSource
import br.com.hellopetdesign.domain.model.Order
import br.com.hellopetdesign.domain.repository.IOrderRepository

class OrderRepository(
    private val remoteOrderDataSource: IOrderDataSource
) : IOrderRepository {
    override suspend fun getAllOrders(): List<Order> {
        return remoteOrderDataSource.getAllOrders()
    }
}