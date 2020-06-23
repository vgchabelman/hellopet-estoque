package br.com.hellopetdesign.presentation.material

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import br.com.hellopetdesign.presentation.R
import kotlinx.android.synthetic.main.fragment_material_inventory.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MaterialInventoryFragment : Fragment() {
    private val materialInventoryViewModel: MaterialInventoryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_material_inventory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        materialInventoryViewModel.materialList.observe(viewLifecycleOwner) {
            materialInventoryList.adapter = MaterialInventoryAdapter(it)
        }
    }

    override fun onResume() {
        super.onResume()

        materialInventoryViewModel.loadMaterials()
    }
}