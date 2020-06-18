package br.com.hellopetdesign.data.repository

import br.com.hellopetdesign.data.datasource.MockLocalProductDatasource
import br.com.hellopetdesign.data.models.Product
import br.com.hellopetdesign.data.models.getMockProduct
import com.nhaarman.mockitokotlin2.any
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class ProductRepositoryTest {
    @ExperimentalCoroutinesApi
    @Test
    fun addProduct() {
        val mockLocalProductDatasource = MockLocalProductDatasource()
        val productRepository = ProductRepository(mockLocalProductDatasource)
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
        val productRepository = ProductRepository(mockLocalProductDatasource)
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
        val productRepository = ProductRepository(mockLocalProductDatasource)
        val product = getMockProduct(0L)
        val product1 = getMockProduct(1L)
        runBlockingTest {
            mockLocalProductDatasource.productList.add(product)
            mockLocalProductDatasource.productList.add(product1)
            assertTrue(productRepository.getAllProducts().size == 2)
            assertEquals(productRepository.getAllProducts()[0], product)
            assertEquals(productRepository.getAllProducts()[1], product1)
        }
    }
}