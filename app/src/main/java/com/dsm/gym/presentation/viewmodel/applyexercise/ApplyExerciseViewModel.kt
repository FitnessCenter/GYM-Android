package com.dsm.gym.presentation.viewmodel.applyexercise

import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.usecase.ApplyExerciseUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import io.reactivex.observers.DisposableSingleObserver
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.ApplyExerciseEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.usecase.CancelApplyExerciseUseCase
import com.dsm.gym.domain.usecase.GetAppliedExercisePersonnelUseCase
import com.dsm.gym.domain.usecase.GetApplyExerciseStateUseCase
import com.dsm.gym.presentation.model.UserInfoModel
import com.dsm.gym.presentation.model.toModel

class ApplyExerciseViewModel(private val applyExerciseUseCase: ApplyExerciseUseCase,
                             private val getAppliedExercisePersonnelUseCase: GetAppliedExercisePersonnelUseCase,
                             private val getApplyExerciseStateUseCase: GetApplyExerciseStateUseCase,
                             private val cancelApplyExerciseUseCase: CancelApplyExerciseUseCase
) : BaseViewModel() {
    val applyExerciseEvent = SingleLiveEvent<String>()
    val applyExerciseState = MutableLiveData<List<ApplyExerciseEntity>>()
    val applyExerciseTime = MutableLiveData<Int>()
    val appliedExercisePersonnel = MutableLiveData<ArrayList<UserInfoModel>>().apply{
        value = ArrayList(emptyList())
    }
    val appliedExercisePersonnelEvent = SingleLiveEvent<Unit>()
    val dismissDialogEvent = SingleLiveEvent<Unit>()

    init {
        getApplyExerciseState()
    }
    fun nineThirtyApplyExercise() {
        applyExerciseEvent.value = "9 : 30 ~ 10 : 00"
        applyExerciseTime.value = 0
    }
    fun tenApplyExercise(){
        applyExerciseEvent.value= "10 : 00 ~ 10 : 30"
        applyExerciseTime.value = 1
    }
    fun tenThirtyApplyExercise(){
        applyExerciseEvent.value= "10 : 30 ~ 11 : 00"
        applyExerciseTime.value = 2
    }


    fun clickGetAppliedExercisePersonnel(time : Int){
        appliedExercisePersonnelEvent.call()
        getAppliedExercisePersonnel(time)
    }
    fun getApplyExerciseState(){
        getApplyExerciseStateUseCase.execute(Unit,  object :
            DisposableSingleObserver<Result<List<ApplyExerciseEntity>>>(){
            override fun onSuccess(result: Result<List<ApplyExerciseEntity>>) {
               when(result) {
                   is Result.Success -> {
                       applyExerciseState.value = result.data
                   }
                   is Result.Error->{
                       when(result.message){
                           Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다."
                           else -> createToastEvent.value = "알 수 없는 오류가 발생했습니다."
                       }
                   }

               }
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다."
            }

        })
    }
    private fun getAppliedExercisePersonnel(time: Int){
        getAppliedExercisePersonnelUseCase.execute(time, object : DisposableSingleObserver<Result<List<UserInfoEntity>>>(){
            override fun onSuccess(result: Result<List<UserInfoEntity>>) {
                when(result){
                    is Result.Success ->{
                        appliedExercisePersonnel.value = ArrayList(result.data.map { it.toModel() })

                    }
                    is Result.Error ->{
                        when(result.message){
                            Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다."
                            else -> createToastEvent.value = "알 수 없는 오류가 발생했습니다."
                        }

                    }
                }
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다."            }

        })
    }
    fun cancelApplyExercise(){
        cancelApplyExerciseUseCase.execute(Unit, object : DisposableSingleObserver<Result<Unit>>(){
            override fun onSuccess(result: Result<Unit>) {
                when(result){
                    is Result.Success ->
                        createToastEvent.value = "취소 되었습니다."
                    is Result.Error ->
                        when(result.message){
                            Message.FORBIDDEN -> createToastEvent.value = "지금은 신청시간이 아닙니다."
                            Message.UNAUTHORIZED -> createToastEvent.value = "인증되지 않은 사용자입니다."
                            Message.SERVER_ERROR -> createToastEvent.value = "서버 오류가 발생했습니다."
                            Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다."
                            Message.CONFLICT -> createToastEvent.value = "이미 신청하셨습니다."
                            else-> createToastEvent.value = "알 수 없는 오류가 발생했습니다."
                        }
                }
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다."
            }

        })
    }
    fun applyExercise(){
        applyExerciseUseCase.execute(applyExerciseTime.value!!, object : DisposableSingleObserver<Result<Unit>>(){
            override fun onSuccess(result: Result<Unit>) {
                when(result){
                    is Result.Success ->{
                        createToastEvent.value = "신청이 완료되었습니다."
                        dismissDialogEvent.call()
                        getApplyExerciseState()

                    }
                    is Result.Error->{
                        when(result.message){
                            Message.FORBIDDEN -> createToastEvent.value = "지금은 신청시간이 아닙니다."
                            Message.UNAUTHORIZED -> createToastEvent.value = "인증되지 않은 사용자입니다."
                            Message.SERVER_ERROR -> createToastEvent.value = "서버 오류가 발생했습니다."
                            Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다."
                            else-> createToastEvent.value = "알 수 없는 오류가 발생했습니다."
                        }

                    }
                }

            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다."
            }

        }
        )


    }
    fun onClickDialogClose(){
        dismissDialogEvent.call()
    }
}