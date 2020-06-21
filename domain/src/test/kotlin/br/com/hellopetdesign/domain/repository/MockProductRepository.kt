package br.com.hellopetdesign.domain.repository

import br.com.hellopetdesign.domain.model.Product

class MockProductRepository : IProductRepository {
    var productList = ArrayList<Product>()

    override suspend fun addProduct(product: Product) {
        productList.add(product)
    }

    override suspend fun removeProduct(product: Product) {
        productList.remove(product)
    }

    override suspend fun getAllProducts(): List<Product> {
        return productList
    }

}