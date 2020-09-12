package com.dsm.gym.presentation.bindingadapter

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dsm.gym.presentation.adapter.EquipmentListAdapter
import com.dsm.gym.presentation.model.EquipmentListModel

@BindingAdapter("equipmentItems")
fun RecyclerView.bindEquipmentItems(equipmentItems: MutableLiveData<ArrayList<EquipmentListModel>>){
    Log.d("aaaaaaaaaa",equipmentItems.value.toString())
    (adapter as EquipmentListAdapter).setItem(equipmentItems)
}