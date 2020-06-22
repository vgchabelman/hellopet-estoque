package br.com.hellopetdesign.presentation.product.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hellopetdesign.domain.ProductInteractor
import br.com.hellopetdesign.domain.model.Product
import kotlinx.coroutines.launch

class AddProductViewModel(private val productInteractor: ProductInteractor) : ViewModel() {
    val newProduct: MutableLiveData<Product> by lazy {
        MutableLiveData<Product>()
    }
    val showErrorName: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean> ()
    }
    val showErrorMaterials: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean> ()
    }

    fun saveProduct() {
        newProduct.value?.let {
            if (productInteractor.isProductNameCorrect(it)
                && productInteractor.isProductMaterialListCorrect(it)) {
                viewModelScope.launch {
                    productInteractor.addProduct(it)
                }
                return
            }

            showErrorName.postValue(!productInteractor.isProductNameCorrect(it))
            showErrorMaterials.postValue(!productInteractor.isProductMaterialListCorrect(it))
        }
    }
}