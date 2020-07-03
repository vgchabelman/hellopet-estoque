package br.com.hellopetdesign.presentation.order

import br.com.hellopetdesign.domain.model.Order
import br.com.hellopetdesign.presentation.R
import br.com.hellopetdesign.presentation.utils.DatabindBaseAdapter

class OrderAdapter(private val orders: List<Order>) : DatabindBaseAdapter() {
    override fun getByPosition(position: Int): Any {
        return orders[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_order
    }

    override fun getItemCount(): Int {
        return orders.size
    }

}