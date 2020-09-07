package com.dsm.gym.data.entity

import com.google.gson.annotations.SerializedName

data class EquipmentData(
    @SerializedName("equipmentName")
    val equipmentName: String = "",
    @SerializedName("purchaseLink")
    val equipmentLink: String = "",
    @SerializedName("price")
    val equipmentPrice: Int = 0,
    @SerializedName("numberOfApply")
    val equipmentQuantity: Int = 0
)