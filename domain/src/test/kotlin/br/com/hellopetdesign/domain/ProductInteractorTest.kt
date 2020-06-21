package br.com.hellopetdesign.domain

import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.repository.MockProductRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals

@ExperimentalCoroutinesApi
class ProductInteractorTest {
    val mockProductRepository = MockProductRepository()
    val productInteractor = ProductInteractor(mockProductRepository)

    @org.junit.Test
    fun getAllProducts() {
        mockProductRepository.productList.clear()
        mockProductRepository.productList.add(Product(0, "0", emptyList()))
        mockProductRepository.productList.add(Product(1, "1", emptyList()))
        mockProductRepository.productList.add(Product(2, "2", emptyList()))

        runBlockingTest {
            assertEquals(productInteractor.getAllProducts(), mockProductRepository.productList)
        }
    }
}