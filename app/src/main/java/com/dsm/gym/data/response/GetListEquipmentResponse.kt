package com.dsm.gym.data.response

import com.dsm.gym.data.entity.EquipmentListData

data class GetListEquipmentResponse(
    val equipmentList: List<EquipmentListData>
)