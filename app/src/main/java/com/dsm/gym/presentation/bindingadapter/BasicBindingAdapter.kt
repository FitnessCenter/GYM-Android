package com.dsm.gym.presentation.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dsm.gym.presentation.adapter.EquipmentListAdapter
import com.dsm.gym.presentation.model.EquipmentListModel

@BindingAdapter("equipmentItems")
fun RecyclerView.bindEquipmentItems(equipmentItems: MutableLiveData<ArrayList<EquipmentListModel>>){
    (adapter as EquipmentListAdapter).setItem(equipmentItems)
}