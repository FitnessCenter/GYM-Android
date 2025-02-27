package com.dsm.gym.presentation.viewmodel.equipment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.usecase.PostDetailEquipmentUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import com.dsm.gym.presentation.model.EquipmentModel
import com.dsm.gym.presentation.model.toEntity
import io.reactivex.observers.DisposableSingleObserver

class EquipmentDetailViewModel(
    private val equipmentUseCase: PostDetailEquipmentUseCase
): BaseViewModel(){

    val equipmentName = MutableLiveData<String>()
    val equipmentLink = MutableLiveData<String>()
    val equipmentPrice = MutableLiveData<String>()
    val equipmentQuantity = MutableLiveData<String>()

    val goMainEquipmentPage = SingleLiveEvent<Unit>()
    val closeDialog = SingleLiveEvent<Unit>()

    fun clickApplyEquipment() {

        val equipmentPrice = equipmentPrice.value!!.toInt()
        val equipmentQuantity = equipmentQuantity.value!!.toInt()

        val equipmentModel = EquipmentModel(equipmentName.value!!,equipmentLink.value!!,equipmentPrice ,equipmentQuantity )

        equipmentUseCase.execute(equipmentModel.toEntity(),object: DisposableSingleObserver<Result<Unit>>(){
            override fun onSuccess(result: Result<Unit>) {
                when (result) {
                    is Result.Success -> applySuccess()
                    is Result.Error -> applyFail(result)
                }
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다"
            }

        })

    }

    fun applySuccess(){
        Log.d("df","jhi")
        createToastEvent.value = "기구신청 성공"
        goMainEquipmentPage.call()
    }

    fun applyFail(result:Result.Error<Unit>){
        when(result.message) {
            Message.SERVER_ERROR -> createToastEvent.value = "서버 오류가 발생했습니다"

            Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다"

            Message.UNKNOWN_ERROR -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"

            else -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

    fun closeDialog()= closeDialog.call()
}

