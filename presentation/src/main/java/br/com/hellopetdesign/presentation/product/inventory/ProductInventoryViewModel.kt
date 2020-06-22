package br.com.hellopetdesign.presentation.product.inventory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.usecases.IProductInteractor
import kotlinx.coroutines.launch

class ProductInventoryViewModel(private val productInteractor: IProductInteractor) : ViewModel() {
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