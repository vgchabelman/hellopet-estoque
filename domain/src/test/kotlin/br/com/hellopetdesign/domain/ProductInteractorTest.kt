package br.com.hellopetdesign.domain

import br.com.hellopetdesign.domain.model.Material
import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.model.ProductMaterial
import br.com.hellopetdesign.domain.model.Supplier
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
        mockProductRepository.productList.add(Product(0, "0", emptyList()))
        mockProductRepository.productList.add(Product(1, "1", emptyList()))
        mockProductRepository.productList.add(Product(2, "2", emptyList()))

        runBlockingTest {
            assertEquals(productInteractor.getAllProducts(), mockProductRepository.productList)
        }
    }

    @Test
    fun `it should return false when product name is empty`() {
        val b = productInteractor.isProductNameCorrect(Product(0, "", emptyList()))
        assertFalse(b)
    }

    @Test
    fun `it should return true when product name is not empty`() {
        val b = productInteractor.isProductNameCorrect(
            Product(0, "Test", emptyList())
        )
        assertTrue(b)
    }

    @Test
    fun `it should return false when list is empty`() {
        val b = productInteractor.isProductMaterialListCorrect(
            Product(0, "Test", emptyList())
        )
        assertFalse(b)
    }

    @Test
    fun `it should return true when list is not empty`() {
        val b = productInteractor.isProductMaterialListCorrect(
            Product(
                0,
                "Test",
                listOf(
                    ProductMaterial(
                        Material(
                            0,
                            "",
                            Supplier(0, "", "")
                        ),
                        1.0
                    )
                )
            )
        )
        assertTrue(b)
    }

}