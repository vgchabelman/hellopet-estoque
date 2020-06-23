package br.com.hellopetdesign.presentation.material

import br.com.hellopetdesign.domain.model.Material
import br.com.hellopetdesign.presentation.R
import br.com.hellopetdesign.presentation.utils.DatabindBaseAdapter

class MaterialInventoryAdapter(private val materialList: List<Material>) : DatabindBaseAdapter() {
    override fun getByPosition(position: Int): Any {
        return materialList[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_material_inventory
    }

    override fun getItemCount(): Int {
        return materialList.size
    }
}