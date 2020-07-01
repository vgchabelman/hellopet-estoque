package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.domain.model.Product

class MockRemoteProductDatasource : IProductDataSource {
    var productList: ArrayList<Product> = ArrayList()
    var lastUpdate = 1

    override suspend fun add(product: Product) {
        productList.add(product)
    }

    override suspend fun add(products: List<Product>) {
        productList.addAll(products)
    }

    override suspend fun remove(product: Product) {
        productList.remove(product)
    }

    override suspend fun getAllProducts(): List<Product> {
        return productList
    }

    override suspend fun getProductLastUpdate(): Int {
        return lastUpdate
    }

    override suspend fun updateProductLastUpdate(index: Int) {
        lastUpdate = index
    }
}