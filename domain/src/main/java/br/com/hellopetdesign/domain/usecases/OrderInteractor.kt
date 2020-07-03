package br.com.hellopetdesign.domain.usecases

import br.com.hellopetdesign.domain.model.Order
import br.com.hellopetdesign.domain.repository.IOrderRepository

class OrderInteractor(private val orderRepository: IOrderRepository) : IOrderInteractor {
    override suspend fun getAllOrders(): List<Order> {
        return orderRepository.getAllOrders()
    }
}