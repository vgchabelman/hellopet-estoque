package br.com.hellopetdesign.presentation.material

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.hellopetdesign.domain.model.Material
import br.com.hellopetdesign.domain.usecases.IMaterialInteractor
import kotlinx.coroutines.launch

class MaterialInventoryViewModel(
    private val materialInteractor: IMaterialInteractor
) : ViewModel() {
    val materialList: MutableLiveData<List<Material>> by lazy {
        MutableLiveData<List<Material>>()
    }

    fun loadMaterials() {
        viewModelScope.launch {
            val l = materialInteractor.getAllMaterial()
            materialList.postValue(l)
        }
    }
}