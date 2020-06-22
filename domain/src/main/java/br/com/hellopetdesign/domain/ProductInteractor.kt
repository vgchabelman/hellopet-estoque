package br.com.hellopetdesign.domain

import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.repository.IProductRepository

class ProductInteractor(private val productRepository: IProductRepository) {
    suspend fun getAllProducts(): List<Product> {
        return productRepository.getAllProducts()
    }

    suspend fun addProduct(product: Product) {
        productRepository.addProduct(product)
    }

    fun isProductNameCorrect(product: Product): Boolean {
        return product.name.isNotEmpty()
    }

    fun isProductMaterialListCorrect(product: Product) : Boolean {
        return product.materials.isNotEmpty()
    }
}