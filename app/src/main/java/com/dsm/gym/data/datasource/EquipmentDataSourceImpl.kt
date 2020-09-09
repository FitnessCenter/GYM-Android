package com.dsm.gym.data.datasource

import com.dsm.gym.data.entity.EquipmentData
import com.dsm.gym.data.entity.EquipmentListData
import com.dsm.gym.data.remote.Api
import com.dsm.gym.data.response.GetListEquipmentResponse
import io.reactivex.Completable
import io.reactivex.Single

class EquipmentDataSourceImpl(
    private val api: Api
) : EquipmentDataSource {
    override fun postDetailEquipment(equipment: EquipmentData): Completable =
        api.postDetailEquipment(equipment)

    override fun getAllEquipment(): Single<GetListEquipmentResponse> =
        api.getAllEquipment()
}