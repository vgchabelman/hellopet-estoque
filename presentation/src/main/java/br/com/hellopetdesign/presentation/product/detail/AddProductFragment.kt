package br.com.hellopetdesign.presentation.product.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.presentation.R
import br.com.hellopetdesign.presentation.databinding.FragmentAddProductBinding
import br.com.hellopetdesign.presentation.utils.BaseFragment
import kotlinx.android.synthetic.main.fragment_add_product.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddProductFragment : BaseFragment() {

    private val viewModel: AddProductViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.newProduct.postValue(Product(0, "", emptyList()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_add_product, container, false)
        val binding = FragmentAddProductBinding.bind(v)
        binding.viewModel = viewModel
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addProductSaveButton.setOnClickListener { viewModel.saveProduct() }

        viewModel.showErrorName.observe(viewLifecycleOwner) {
            productNameInputLayout.error = if (it) "Nome obrigatório" else ""
        }
        viewModel.showErrorMaterials.observe(viewLifecycleOwner) {
            productMaterialListHeader.error =
                if (it) "Pelo menos 1 item deve ser adicionado" else ""
        }
        viewModel.newProduct.observe(viewLifecycleOwner) {
            productMaterialList.adapter = ProductMaterialAdapter(it.materials)
        }
    }

    override fun screenName(): String {
        return "Novo Produto"
    }
}