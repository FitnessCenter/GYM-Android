package com.dsm.gym.domain.entity

import com.dsm.gym.data.entity.AppliedUserData
import com.dsm.gym.presentation.model.EquipmentListModel

data class EquipmentListEntity(
    val id: Int = 0,
    val numberOfApply: String,
    val price: String,
    val equipmentName: String = "",
    val sex: Boolean,
    val purchaseLink:String = "",
    val appliedUser: AppliedUserData
)

fun EquipmentListEntity.toModel() =
    EquipmentListModel(
        id = id,
        numberOfApply = numberOfApply,
        price = price,
        equipmentName = equipmentName,
        sex = sex,
        purchaseLink = purchaseLink,
        appliedUser = appliedUser
    )