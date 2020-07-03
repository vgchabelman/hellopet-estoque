package br.com.hellopetdesign.presentation

import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.usecases.IProductInteractor
import br.com.hellopetdesign.presentation.product.detail.AddProductViewModel
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.times
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class AddProductViewModelTest {
    private val mockInteractor: IProductInteractor = Mockito.mock(
        IProductInteractor::class.java
    )
    private val addProductViewModel = AddProductViewModel(mockInteractor)

    @Before
    fun init() {
        addProductViewModel.newProduct.postValue(Product(0, "", emptyList(), 1))
    }

    @Test
    fun `it should not save the product if product is not ready`() {
        runBlockingTest {
            Mockito.`when`(mockInteractor.isProductNameCorrect(any())).thenReturn(false)
            Mockito.`when`(mockInteractor.isProductMaterialListCorrect(any())).thenReturn(true)
            addProductViewModel.saveProduct()
            Mockito.`when`(mockInteractor.isProductNameCorrect(any())).thenReturn(true)
            Mockito.`when`(mockInteractor.isProductMaterialListCorrect(any())).thenReturn(false)
            addProductViewModel.saveProduct()
            Mockito.verify(mockInteractor, times(0)).addProduct(any())
        }
    }

    @Test
    fun `it should save product when product is ready`() {
//        runBlockingTest {
//            Mockito.`when`(mockInteractor.isProductNameCorrect(any())).thenReturn(true)
//            Mockito.`when`(mockInteractor.isProductMaterialListCorrect(any())).thenReturn(true)
//            addProductViewModel.saveProduct()
//            Mockito.verify(mockInteractor, times(1)).addProduct(any())
//        }
    }
}