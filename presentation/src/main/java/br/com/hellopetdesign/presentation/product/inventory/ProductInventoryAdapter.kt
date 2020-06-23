package br.com.hellopetdesign.presentation.product.inventory

import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.presentation.R
import br.com.hellopetdesign.presentation.utils.DatabindBaseAdapter

class ProductInventoryAdapter(private val productList: List<Product>) : DatabindBaseAdapter() {

    override fun getByPosition(position: Int): Any {
        return productList[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_product_inventory
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}