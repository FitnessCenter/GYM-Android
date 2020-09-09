package com.dsm.gym.presentation.model

import com.dsm.gym.data.entity.AppliedUserData
import com.dsm.gym.data.entity.EquipmentListData
import com.dsm.gym.domain.entity.EquipmentListEntity

data class EquipmentListModel(
    val id: Int = 0,
    val numberOfApply: Int = 0,
    val price: Int = 0,
    val equipmentName: String = "",
    val sex: Boolean,
    val purchaseLink:String = "",
    val appliedUser: AppliedUserData
)

fun EquipmentListModel.toEntity() =
    EquipmentListEntity(
        id = id,
        numberOfApply = numberOfApply,
        price = price,
        equipmentName = equipmentName,
        sex = sex,
        purchaseLink = purchaseLink,
        appliedUser = appliedUser
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