package br.com.hellopetdesign.domain.usecases

import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.repository.IProductRepository

class ProductInteractor(private val productRepository: IProductRepository) :
    IProductInteractor {
    override suspend fun getAllProducts(): List<Product> {
        return productRepository.getAllProducts()
    }

    override suspend fun addProduct(product: Product) {
        productRepository.addProduct(product)
    }

    override fun isProductNameCorrect(product: Product): Boolean {
        return product.name.isNotEmpty()
    }

    override fun isProductMaterialListCorrect(product: Product) : Boolean {
        return product.materials.isNotEmpty()
    }
}