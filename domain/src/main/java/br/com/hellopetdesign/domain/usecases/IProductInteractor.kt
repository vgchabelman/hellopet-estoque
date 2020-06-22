package br.com.hellopetdesign.domain.usecases

import br.com.hellopetdesign.domain.model.Product

interface IProductInteractor {
    suspend fun getAllProducts(): List<Product>
    suspend fun addProduct(product: Product)
    fun isProductNameCorrect(product: Product): Boolean
    fun isProductMaterialListCorrect(product: Product) : Boolean
}