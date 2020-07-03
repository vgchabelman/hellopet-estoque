package br.com.hellopetdesign.presentation.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import br.com.hellopetdesign.presentation.R
import kotlinx.android.synthetic.main.fragment_order.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderFragment : Fragment() {

    private val orderViewModel: OrderViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderViewModel.orderList.observe(viewLifecycleOwner) {
            orderList.adapter = OrderAdapter(it)
        }
    }

    override fun onResume() {
        super.onResume()

        orderViewModel.loadOrders()
    }
}