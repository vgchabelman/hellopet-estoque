package br.com.hellopetdesign.presentation.product.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import br.com.hellopetdesign.presentation.R
import br.com.hellopetdesign.presentation.utils.BaseFragment
import kotlinx.android.synthetic.main.fragment_product_inventory.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductInventoryFragment : BaseFragment() {

    private val productInventoryViewModel: ProductInventoryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_inventory, container, false)
    }

    override fun screenName(): String {
        return "Produtos"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productInventoryViewModel.productList.observe(viewLifecycleOwner) {
            productInventoryList.adapter =
                ProductInventoryAdapter(
                    it
                )
        }

        productInventoryFab.setOnClickListener {
            findNavController().navigate(R.id.action_productInventoryFragment_to_addProductFragment)
        }
    }

    override fun onResume() {
        super.onResume()

        productInventoryViewModel.loadProductList()
    }
}