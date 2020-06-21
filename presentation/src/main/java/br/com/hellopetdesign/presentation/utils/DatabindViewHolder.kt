package br.com.hellopetdesign.presentation.utils

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class DatabindViewHolder(
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: Any?) {
        binding.setVariable(MODEL_VAR, obj)
        binding.executePendingBindings()
    }

    companion object {
        const val MODEL_VAR = 0
    }
}