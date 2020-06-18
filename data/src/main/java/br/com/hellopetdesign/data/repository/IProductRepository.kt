package br.com.hellopetdesign.data.repository

import br.com.hellopetdesign.data.models.Product

interface IProductRepository {
    suspend fun addProduct(product: Product)
    suspend fun removeProduct(product: Product)
    suspend fun getAllProducts(): List<Product>
}