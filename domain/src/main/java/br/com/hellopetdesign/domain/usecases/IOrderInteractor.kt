package br.com.hellopetdesign.domain.usecases

import br.com.hellopetdesign.domain.model.Order

interface IOrderInteractor {
    suspend fun getAllOrders(): List<Order>
}