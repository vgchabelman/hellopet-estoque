package br.com.hellopetdesign.domain.repository

import br.com.hellopetdesign.domain.model.Product

interface IProductRepository {
    suspend fun addProduct(product: Product)
    suspend fun removeProduct(product: Product)
    suspend fun getAllProducts(): List<Product>
}