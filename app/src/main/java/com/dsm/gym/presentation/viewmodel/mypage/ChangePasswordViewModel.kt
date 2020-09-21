package com.dsm.gym.presentation.viewmodel.mypage

import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.usecase.ChangePasswordUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import com.dsm.gym.presentation.model.ChangePasswordModel
import com.dsm.gym.presentation.model.toEntity
import io.reactivex.observers.DisposableSingleObserver

class ChangePasswordViewModel(private val changePasswordUseCase: ChangePasswordUseCase) : BaseViewModel(){

    val currentPassword = MutableLiveData<String>()
    val newPassword = MutableLiveData<String>()
    val passwordChangedEvent = SingleLiveEvent<Unit>()

    fun changePassword(){
        changePasswordUseCase.execute(ChangePasswordModel(
            newPassword.value!!,currentPassword.value!!
        ).toEntity(), object : DisposableSingleObserver<Result<Unit>>(){
            override fun onSuccess(result: Result<Unit>) {
                when(result){
                    is Result.Success-> {
                        createToastEvent.value = "비밀번호를 변경하였습니다."
                        passwordChangedEvent.call()
                    }
                    is Result.Error->{
                        when(result.message){
                            Message.FORBIDDEN-> createToastEvent.value = "현재 비밀번호가 맞지 않습니다."
                            else ->  createToastEvent.value = "알 수 없는 오류가 발생하였습니다."
                        }

                    }
                }
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

        }
    )}

}