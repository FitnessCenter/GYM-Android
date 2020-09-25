package com.dsm.gym.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dsm.gym.databinding.ItemEquipmentHistoryBinding
import com.dsm.gym.presentation.model.EquipmentListModel
import com.dsm.gym.presentation.viewmodel.mypage.EquipmentHistoryViewModel

class MyEquipmentAdapter(private val viewModel: EquipmentHistoryViewModel) : RecyclerView.Adapter<BindingViewHolder<EquipmentListModel>>() {

    private var items =ArrayList<EquipmentListModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<EquipmentListModel> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemEquipmentHistoryBinding.inflate(layoutInflater,  parent, false)
        return BindingViewHolder(binding,viewModel)

    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BindingViewHolder<EquipmentListModel>, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items : MutableLiveData<ArrayList<EquipmentListModel>>){
        this.items = items.value!!
        notifyDataSetChanged()

    }

}