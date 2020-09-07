package com.dsm.gym.presentation.viewmodel.equipment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.entity.EquipmentEntity
import com.dsm.gym.domain.usecase.PostDetailEquipmentUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import com.dsm.gym.presentation.mapper.EquipmentMapper
import com.dsm.gym.presentation.model.EquipmentModel
import io.reactivex.subscribers.DisposableSubscriber

class EquipmentViewModel(
    private val equipmentUseCase: PostDetailEquipmentUseCase,
    private val equipmentMapper: EquipmentMapper
): BaseViewModel(){

    val equipmentName = MutableLiveData<String>()
    val equipmentLink = MutableLiveData<String>()
    val equipmentPrice = MutableLiveData(1)
    val equipmentQuantity = MutableLiveData(1)

    //val goMainEquipmentPage = SingleLiveEvent<Unit>()
    val closeDialog = SingleLiveEvent<Unit>()

    fun clickApplyEquipment() {
//        equipmentPrice.postValue(equipmentPrice.value!!)

        val equipmentModel = EquipmentModel(equipmentName.value!!,equipmentLink.value!!,equipmentPrice.value!! ,equipmentQuantity.value!!)
        Log.d("hi","${equipmentMapper.mapFrom(equipmentModel)} || $equipmentModel")

        equipmentUseCase.execute(equipmentMapper.mapFrom(equipmentModel), object:DisposableSubscriber<Pair<EquipmentEntity,ErrorHandlerEntity>>(){
            override fun onNext(t: Pair<EquipmentEntity, ErrorHandlerEntity>) {
                if(t.second.isSuccess) {
                    Log.d("equipmentSuccess","asldfas")
                    applySuccess("success")
                }
                else {
                    Log.d("why","${t.second.isSuccess}")
                    Log.d("equipmentFail","${t.second.message} + sd")
                    applyFail(t.second.message)
                }
            }

            override fun onError(t: Throwable?) {

            }

            override fun onComplete() {

            }

        })
    }

    fun applySuccess(message: String){
        createToastEvent.value = message
    }

    fun applyFail(message:String){
        createToastEvent.value = message
    }

    fun closeDialog(){
        Log.d("dfd","dfd")
        closeDialog.call()
    }
}

