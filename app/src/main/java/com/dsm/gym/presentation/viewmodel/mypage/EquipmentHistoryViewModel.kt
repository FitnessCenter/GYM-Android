package com.dsm.gym.presentation.viewmodel.mypage

import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.EquipmentListEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.usecase.CancelMyEquipmentUseCase
import com.dsm.gym.domain.usecase.GetMyEquipmentUseCase
import com.dsm.gym.domain.usecase.GetUserInfoUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import com.dsm.gym.presentation.model.EquipmentListModel
import com.dsm.gym.presentation.model.toModel
import io.reactivex.observers.DisposableSingleObserver

class EquipmentHistoryViewModel(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getMyEquipmentUseCase: GetMyEquipmentUseCase,
    private val cancelMyEquipmentUseCase: CancelMyEquipmentUseCase
    ) : BaseViewModel() {

    val dismissEvent = SingleLiveEvent<Unit>()
    val username = MutableLiveData<String>()
    val myEquipment = MutableLiveData<ArrayList<EquipmentListModel>>().apply{
        value = ArrayList(emptyList())
    }
    private var cancelEquipmentId = 0

    val cancelEquipmentEvent = SingleLiveEvent<Unit>()

    init {
        getUserInfo()
        getMyEquipment()
    }
    fun clickCancelEquipment(id : Int){
        cancelEquipmentEvent.call()
        cancelEquipmentId = id

    }

    fun cancelMyEquipment(){
        cancelMyEquipmentUseCase.execute(cancelEquipmentId, object : DisposableSingleObserver<Result<Unit>>(){
            override fun onSuccess(result : Result<Unit>) {
                when(result){
                    is Result.Success->{
                        createToastEvent.value = "신청이 취소되었습니다."
                        dismissEvent.call()
                        getMyEquipment()
                    }
                    is Result.Error->{
                        when(result.message){
                            Message.UNAUTHORIZED -> createToastEvent.value = "인증되지 않은 사용자입니다."

                            Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다."

                            else ->  createToastEvent.value = "알 수 없는 오류가 발생하였습니다."                        }
                    }
                }
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다"
            }

        })
    }
    private fun getMyEquipment(){
        getMyEquipmentUseCase.execute("me", object : DisposableSingleObserver<Result<List<EquipmentListEntity>>>(){
            override fun onSuccess(result: Result<List<EquipmentListEntity>>) {
                when(result){
                    is Result.Success->{
                        myEquipment.value =ArrayList(result.data.map {
                            it.toModel()
                        })

                    }
                    is Result.Error-> {
                        when (result.message) {
                            Message.SERVER_ERROR -> createToastEvent.value = "서버 오류가 발생했습니다"

                            Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다"

                            else -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"

                        }
                    }
                }

            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다"
            }

        })
    }
    private fun getUserInfo() {

        getUserInfoUseCase.execute(Unit, object : DisposableSingleObserver<Result<UserInfoEntity>>() {
            override fun onSuccess(result: Result<UserInfoEntity>) {
                when (result) {
                    is Result.Success -> username.value = result.data.studentName
                    is Result.Error -> when (result.message) {
                        Message.SERVER_ERROR -> createToastEvent.value = "서버 오류가 발생했습니다"

                        Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다"

                        else -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"
                    }
                }
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다"
            }

        })
    }


}