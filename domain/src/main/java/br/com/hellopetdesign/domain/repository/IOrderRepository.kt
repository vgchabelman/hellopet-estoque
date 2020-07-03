package br.com.hellopetdesign.domain.repository

import br.com.hellopetdesign.domain.model.Order

interface IOrderRepository {
    suspend fun getAllOrders(): List<Order>
}