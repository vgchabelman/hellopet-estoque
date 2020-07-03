package br.com.hellopetdesign.presentation.order

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hellopetdesign.domain.model.Order
import br.com.hellopetdesign.domain.usecases.IOrderInteractor
import kotlinx.coroutines.launch

class OrderViewModel(
    private val orderInteractor: IOrderInteractor
) : ViewModel() {
    val orderList: MutableLiveData<List<Order>> by lazy {
        MutableLiveData<List<Order>>()
    }

    fun loadOrders() {
        viewModelScope.launch {
            val list = orderInteractor.getAllOrders()
            orderList.postValue(list)
        }
    }
}