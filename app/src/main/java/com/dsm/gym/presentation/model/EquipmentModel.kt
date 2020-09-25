package com.dsm.gym.presentation.model

import com.dsm.gym.domain.entity.EquipmentEntity

data class EquipmentModel(
    var equipmentName: String = "",
    var equipmentLink: String = "",
    var equipmentPrice: Int = 0,
    var equipmentQuantity: Int = 0
)

fun EquipmentModel.toEntity() =
    EquipmentEntity(
        equipmentName = equipmentName,
        equipmentLink = equipmentLink,
        equipmentPrice = equipmentPrice,
        equipmentQuantity = equipmentQuantity
    )