package br.com.hellopetdesign.data.repository

import br.com.hellopetdesign.data.datasource.IProductDataSource
import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.repository.IProductRepository

class ProductRepository(
    private val localDataProduct: IProductDataSource,
    private val remoteProductDataSource: IProductDataSource
) :
    IProductRepository {
    override suspend fun addProduct(product: Product) {
        localDataProduct.add(product)
    }

    override suspend fun removeProduct(product: Product) {
        localDataProduct.remove(product)
    }

    override suspend fun getAllProducts(): List<Product> {
        if (localDataProduct.getProductLastUpdate() < remoteProductDataSource.getProductLastUpdate()) {
            val pList = remoteProductDataSource.getAllProducts()
            localDataProduct.add(pList)

            return pList
        }
        return remoteProductDataSource.getAllProducts()
    }
}