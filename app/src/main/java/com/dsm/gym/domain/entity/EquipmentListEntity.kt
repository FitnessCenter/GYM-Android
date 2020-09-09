package com.dsm.gym.domain.entity

import com.dsm.gym.data.entity.AppliedUserData

data class EquipmentListEntity(
    val id: Int = 0,
    val numberOfApply: Int = 0,
    val price: Int = 0,
    val equipmentName: String = "",
    val sex: Boolean,
    val purchaseLink:String = "",
    val appliedUser: AppliedUserData
)
