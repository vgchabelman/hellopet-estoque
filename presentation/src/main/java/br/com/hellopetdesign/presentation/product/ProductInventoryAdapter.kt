package br.com.hellopetdesign.presentation.product

import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.presentation.utils.DatabindBaseAdapter

class ProductInventoryAdapter(private val productList: List<Product>) : DatabindBaseAdapter() {

    override fun getByPosition(position: Int): Any {
        return productList[position]
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}