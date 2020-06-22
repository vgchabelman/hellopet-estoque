package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.domain.model.Product

class MockLocalProductDatasource : IProductDataSource {
    var productList: ArrayList<Product> = ArrayList()

    override suspend fun add(product: Product) {
        productList.add(product)
    }

    override suspend fun remove(product: Product) {
        productList.remove(product)
    }

    override suspend fun getAllProducts(): List<Product> {
        return productList
    }
}