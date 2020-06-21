package br.com.hellopetdesign.presentation.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import br.com.hellopetdesign.presentation.R
import kotlinx.android.synthetic.main.fragment_product_inventory.*

class ProductInventoryFragment : Fragment() {

    private val viewModel: ProductInventoryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.productList.observe(viewLifecycleOwner) {
            productInventoryList.adapter = ProductInventoryAdapter(it)
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadProductList()
    }
}