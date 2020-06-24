package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.domain.model.Product

interface IProductDataSource {
    suspend fun add(product: Product)

    suspend fun add(products: List<Product>)

    suspend fun remove(product: Product)

    suspend fun getAllProducts(): List<Product>

    suspend fun getProductLastUpdate() : Int

    suspend fun updateProductLastUpdate(index: Int)
}