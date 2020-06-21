package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.domain.model.Product

interface IProductDataSource {
    suspend fun add(product: Product)

    suspend fun remove(product: Product)

    suspend fun getAllProducts(): List<Product>
}