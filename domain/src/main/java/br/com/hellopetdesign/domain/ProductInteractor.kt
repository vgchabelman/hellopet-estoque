package br.com.hellopetdesign.domain

import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.repository.IProductRepository

class ProductInteractor(private val productRepository: IProductRepository) {
    suspend fun getAllProducts(): List<Product> {
        return productRepository.getAllProducts()
    }
}