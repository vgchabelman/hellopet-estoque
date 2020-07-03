package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.domain.model.Order

interface IOrderDataSource {
    suspend fun getAllOrders(): List<Order>
}