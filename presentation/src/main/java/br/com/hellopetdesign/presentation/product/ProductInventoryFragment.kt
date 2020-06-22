package br.com.hellopetdesign.presentation.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import br.com.hellopetdesign.presentation.R
import kotlinx.android.synthetic.main.fragment_product_inventory.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductInventoryFragment : Fragment() {

    private val productInventoryViewModel: ProductInventoryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productInventoryViewModel.productList.observe(viewLifecycleOwner) {
            productInventoryList.adapter = ProductInventoryAdapter(it)
        }
    }

    override fun onResume() {
        super.onResume()

        productInventoryViewModel.loadProductList()
    }
}