package com.dsm.gym.data.mapper

import com.dsm.gym.data.entity.EquipmentData
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.mapper.BaseMapper

class EquipmentDataMapper : BaseMapper<EquipmentEntity, EquipmentData> {
    override fun mapFrom(from: EquipmentEntity): EquipmentData =
        EquipmentData(
            equipmentName = from.equipmentName,
            equipmentLink = from.equipmentLink,
            equipmentPrice = from.equipmentPrice,
            equipmentQuantity = from.equipmentQuantity
        )

    fun mapDataToEntity(from: EquipmentData): EquipmentEntity
        = EquipmentEntity(
        equipmentName = from.equipmentName,
        equipmentLink = from.equipmentLink,
        equipmentPrice = from.equipmentPrice,
        equipmentQuantity = from.equipmentQuantity
    )
}