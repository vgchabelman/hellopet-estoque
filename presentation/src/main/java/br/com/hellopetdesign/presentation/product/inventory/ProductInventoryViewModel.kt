package br.com.hellopetdesign.presentation.product.inventory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hellopetdesign.domain.ProductInteractor
import br.com.hellopetdesign.domain.model.Product
import kotlinx.coroutines.launch

class ProductInventoryViewModel(private val productInteractor: ProductInteractor) : ViewModel() {
    val productList: MutableLiveData<List<Product>> by lazy {
        MutableLiveData<List<Product>>()
    }

    fun loadProductList() {
        viewModelScope.launch {
            val list = productInteractor.getAllProducts()
            productList.postValue(list)
        }
    }
}