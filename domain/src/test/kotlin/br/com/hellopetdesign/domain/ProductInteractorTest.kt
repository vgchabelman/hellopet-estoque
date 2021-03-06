package br.com.hellopetdesign.domain

import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.model.ProductMaterial
import br.com.hellopetdesign.domain.repository.MockProductRepository
import br.com.hellopetdesign.domain.usecases.ProductInteractor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Test

@ExperimentalCoroutinesApi
class ProductInteractorTest {
    private val mockProductRepository = MockProductRepository()
    private val productInteractor =
        ProductInteractor(
            mockProductRepository
        )

    @Test
    fun `it should return all products in list`() {
        mockProductRepository.productList.clear()
        mockProductRepository.productList.add(Product(0, "0", emptyList(),1))
        mockProductRepository.productList.add(Product(1, "1", emptyList(),1))
        mockProductRepository.productList.add(Product(2, "2", emptyList(),1))

        runBlockingTest {
            assertEquals(productInteractor.getAllProducts(), mockProductRepository.productList)
        }
    }

    @Test
    fun `it should add product`() {
        mockProductRepository.productList.clear()

        runBlockingTest {
            val p = Product(0, "0", emptyList(),1)
            productInteractor.addProduct(p)
            assertEquals(mockProductRepository.productList[0], p)
        }
    }

    @Test
    fun `it should return false when product name is empty`() {
        val b = productInteractor.isProductNameCorrect(Product(0, "", emptyList(),1))
        assertFalse(b)
    }

    @Test
    fun `it should return true when product name is not empty`() {
        val b = productInteractor.isProductNameCorrect(
            Product(0, "Test", emptyList(),1)
        )
        assertTrue(b)
    }

    @Test
    fun `it should return false when list is empty`() {
        val b = productInteractor.isProductMaterialListCorrect(
            Product(0, "Test", emptyList(),1)
        )
        assertFalse(b)
    }

    @Test
    fun `it should return true when list is not empty`() {
        val b = productInteractor.isProductMaterialListCorrect(
            Product(
                0,
                "Test",
                listOf(ProductMaterial(quantity = 1.0)),
                1
            )
        )
        assertTrue(b)
    }

}