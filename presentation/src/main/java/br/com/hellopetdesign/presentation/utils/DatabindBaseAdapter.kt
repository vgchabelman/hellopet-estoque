package br.com.hellopetdesign.presentation.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class DatabindBaseAdapter : RecyclerView.Adapter<DatabindViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatabindViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater, viewType, parent, false
        )
        return DatabindViewHolder(binding)
    }

    abstract fun getByPosition(position: Int): Any

    override fun onBindViewHolder(holder: DatabindViewHolder, position: Int) {
        holder.bind(getByPosition(position))
    }

    abstract fun getLayoutIdForPosition(position: Int): Int

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }
}