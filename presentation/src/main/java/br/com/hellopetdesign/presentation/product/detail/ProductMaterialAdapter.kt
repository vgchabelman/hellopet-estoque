package br.com.hellopetdesign.presentation.product.detail

import br.com.hellopetdesign.domain.model.ProductMaterial
import br.com.hellopetdesign.presentation.R
import br.com.hellopetdesign.presentation.utils.DatabindBaseAdapter

class ProductMaterialAdapter(
    private val productMaterialList: List<ProductMaterial>
) : DatabindBaseAdapter() {

    override fun getByPosition(position: Int): Any {
        return productMaterialList[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_product_material
    }

    override fun getItemCount(): Int {
        return productMaterialList.size
    }
}