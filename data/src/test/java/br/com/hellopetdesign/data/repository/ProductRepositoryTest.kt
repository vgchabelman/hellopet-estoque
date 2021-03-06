package br.com.hellopetdesign.data.repository

import br.com.hellopetdesign.data.datasource.MockLocalProductDatasource
import br.com.hellopetdesign.data.datasource.MockRemoteProductDatasource
import br.com.hellopetdesign.data.models.getMockProduct
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ProductRepositoryTest {

    @ExperimentalCoroutinesApi
    @Test
    fun addProduct() {
        val mockLocalProductDatasource = MockLocalProductDatasource()
        val mockRemoteProductDatasource = MockRemoteProductDatasource()

        val productRepository = ProductRepository(mockLocalProductDatasource, mockRemoteProductDatasource)
        val product = getMockProduct(0L)
        runBlockingTest {
            productRepository.addProduct(product)
            assertTrue(mockLocalProductDatasource.productList.size == 1)
            assertEquals(mockLocalProductDatasource.productList[0], product)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun removeProduct() {
        val mockLocalProductDatasource = MockLocalProductDatasource()
        val mockRemoteProductDatasource = MockRemoteProductDatasource()

        val productRepository = ProductRepository(mockLocalProductDatasource, mockRemoteProductDatasource)
        val product = getMockProduct(0L)
        runBlockingTest {
            mockLocalProductDatasource.productList.add(product)
            productRepository.removeProduct(product)
            assertTrue(mockLocalProductDatasource.productList.isEmpty())
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getAllProducts() {
        val mockLocalProductDatasource = MockLocalProductDatasource()
        val mockRemoteProductDatasource = MockRemoteProductDatasource()

        val productRepository = ProductRepository(mockLocalProductDatasource, mockRemoteProductDatasource)
        val product = getMockProduct(0L)
        val product1 = getMockProduct(1L)
        runBlockingTest {
            mockRemoteProductDatasource.productList.add(product)
            mockRemoteProductDatasource.productList.add(product1)
            val size = productRepository.getAllProducts().size
            assertTrue(size == 2)
            assertEquals(productRepository.getAllProducts()[0], product)
            assertEquals(productRepository.getAllProducts()[1], product1)
        }
    }
}