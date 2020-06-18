package br.com.hellopetdesign.data.repository

import br.com.hellopetdesign.data.datasource.IProductDataSource
import br.com.hellopetdesign.data.models.Product

class ProductRepository(private val localDataProduct: IProductDataSource): IProductRepository {
    override suspend fun addProduct(product: Product) {
        localDataProduct.add(product)
    }

    override suspend fun removeProduct(product: Product) {
        localDataProduct.remove(product)
    }

    override suspend fun getAllProducts(): List<Product> {
        return localDataProduct.getAllProducts()
    }
}