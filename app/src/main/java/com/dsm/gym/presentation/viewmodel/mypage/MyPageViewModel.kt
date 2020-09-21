package com.dsm.gym.presentation.viewmodel.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.usecase.GetUserInfoUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import io.reactivex.observers.DisposableSingleObserver

class MyPageViewModel(private val getUserInfoUseCase: GetUserInfoUseCase) : BaseViewModel() {
    init {
        getUserInfo()
    }
    val userInfo = MutableLiveData<UserInfoEntity>()

    fun getUserInfo(){
        getUserInfoUseCase.execute(Unit, object : DisposableSingleObserver<Result<UserInfoEntity>>(){
            override fun onSuccess(result: Result<UserInfoEntity>) {
                when (result) {
                    is Result.Success -> userInfo.value = result.data
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