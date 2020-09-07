package com.dsm.gym.presentation.mapper

import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.mapper.BaseMapper
import com.dsm.gym.presentation.model.EquipmentModel

class EquipmentMapper: BaseMapper<EquipmentModel, EquipmentEntity> {
    override fun mapFrom(from: EquipmentModel): EquipmentEntity
            = EquipmentEntity(
        equipmentName = from.equipmentName,
        equipmentQuantity = from.equipmentQuantity,
        equipmentPrice = from.equipmentPrice,
        equipmentLink = from.equipmentLink
    )
}