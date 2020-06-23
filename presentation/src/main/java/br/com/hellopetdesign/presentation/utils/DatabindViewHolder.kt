package br.com.hellopetdesign.presentation.utils

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import br.com.hellopetdesign.presentation.BR

class DatabindViewHolder(
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: Any?) {
        binding.setVariable(BR.model, obj)
        binding.executePendingBindings()
    }
}