package com.dsm.gym.data.entity

import com.dsm.gym.domain.entity.EquipmentListEntity
import com.google.gson.annotations.SerializedName

data class EquipmentListData(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("numberOfApply")
    val numberOfApply: Int = 0,
    @SerializedName("price")
    val price: Int = 0,
    @SerializedName("equipmentName")
    val equipmentName: String = "",
    @SerializedName("sex")
    val sex: Boolean,
    @SerializedName("purchaseLink")
    val purchaseLink:String = "",
    @SerializedName("appliedUser")
    val appliedUser:AppliedUserData
)

fun EquipmentListEntity.toDataEntity() =
    EquipmentListData(
        id = id,
        numberOfApply = numberOfApply,
        price = price,
        equipmentName = equipmentName,
        sex = sex,
        purchaseLink = purchaseLink,
        appliedUser = appliedUser
    )

fun EquipmentListData.toEntity() =
    EquipmentListEntity(
        id = id,
        numberOfApply = numberOfApply,
        price = price,
        equipmentName = equipmentName,
        sex = sex,
        purchaseLink = purchaseLink,
        appliedUser = appliedUser
    )