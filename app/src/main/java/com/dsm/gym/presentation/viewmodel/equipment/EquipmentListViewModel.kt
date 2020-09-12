package com.dsm.gym.presentation.viewmodel.equipment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.EquipmentListEntity
import com.dsm.gym.domain.entity.toModel
import com.dsm.gym.domain.usecase.GetEquipmentUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.model.EquipmentListModel
import io.reactivex.observers.DisposableSingleObserver

class EquipmentListViewModel(
    private val useCase: GetEquipmentUseCase
): BaseViewModel(){
    val equipmentList = MutableLiveData<ArrayList<EquipmentListModel>>().apply{
        value = ArrayList(emptyList())
    }

    init{
        getData()
    }

    private fun getData(){
        useCase.execute(Unit, object:DisposableSingleObserver<Result<List<EquipmentListEntity>>>(){
            override fun onSuccess(result: Result<List<EquipmentListEntity>>) {
                when(result){
                    is Result.Success -> getListSuccess(result.data.map{it.toModel()})
                    is Result.Error -> getListFail(result.message, result.data!!.map{it.toModel()})
                }
            }

            override fun onError(e: Throwable) {
                Log.d("fail",e.message.toString())
            }

        })
    }

    fun getListSuccess(equipmentList: List<EquipmentListModel>) {
        this.equipmentList.value = ArrayList(equipmentList)
        Log.d("vcddfaa",this.equipmentList.value.toString())
    }

    fun getListFail(result: Message, equipmentList: List<EquipmentListModel>) {
        this.equipmentList.value = ArrayList(equipmentList)

        when(result){
            Message.SERVER_ERROR -> createToastEvent.value = "서버 오류가 발생했습니다"

            Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다"

            Message.UNKNOWN_ERROR -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"

            else -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"

        }

    }
}