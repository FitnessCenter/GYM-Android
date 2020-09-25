package com.dsm.gym.presentation.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class BindingViewHolder<T>(val binding: ViewDataBinding, private val viewModel: ViewModel) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item : T){
        binding.setVariable(BR.equipmentItem, item)
        binding.setVariable(BR.vm, viewModel)

    }
}