package com.dsm.gym.presentation.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.dsm.gym.presentation.adapter.ApplyExercisePersonnelAdapter
import com.dsm.gym.presentation.adapter.EquipmentListAdapter
import com.dsm.gym.presentation.adapter.MyEquipmentAdapter
import com.dsm.gym.presentation.model.EquipmentListModel
import com.dsm.gym.presentation.model.UserInfoModel

@BindingAdapter("equipmentItems")
fun RecyclerView.bindEquipmentItems(equipmentItems: MutableLiveData<ArrayList<EquipmentListModel>>){
    (adapter as EquipmentListAdapter).setItem(equipmentItems)
}

@BindingAdapter("appliedPersonnelItems")
fun RecyclerView.bindAppliedPersonnelItems(appliedPersonnelItems: MutableLiveData<ArrayList<UserInfoModel>>){
    (adapter as ApplyExercisePersonnelAdapter).setItem(appliedPersonnelItems)

  @BindingAdapter("myEquipmentItems")
fun RecyclerView.bindMyEquipmentItems(equipmentItems: MutableLiveData<ArrayList<EquipmentListModel>>){
    (adapter as MyEquipmentAdapter).setItems(equipmentItems)
}