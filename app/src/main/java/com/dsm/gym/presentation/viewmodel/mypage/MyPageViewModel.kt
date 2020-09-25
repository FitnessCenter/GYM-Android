package com.dsm.gym.presentation.viewmodel.mypage

import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.usecase.GetUserInfoUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import com.dsm.gym.presentation.model.UserInfoModel
import com.dsm.gym.presentation.model.toModel
import io.reactivex.observers.DisposableSingleObserver

class MyPageViewModel(private val getUserInfoUseCase: GetUserInfoUseCase,
) : BaseViewModel() {
    init {
        getUserInfo()
    }
    val userInfo = MutableLiveData<UserInfoModel>()

    val userGrade = MutableLiveData<String>()

    val userClass = MutableLiveData<String>()

    val userNumber = MutableLiveData<String>()

    val changePasswordEvent = SingleLiveEvent<Unit>()

    val equipmentHistoryEvent = SingleLiveEvent<Unit>()

    val logoutEvent = SingleLiveEvent<Unit>()

    val logoutConfirmEvent = SingleLiveEvent<Unit>()

    val logoutCancelEvent = SingleLiveEvent<Unit>()



    private fun getUserInfo(){
        getUserInfoUseCase.execute(Unit, object : DisposableSingleObserver<Result<UserInfoEntity>>(){
            override fun onSuccess(result: Result<UserInfoEntity>) {
                when (result) {
                    is Result.Success -> {
                        userInfo.value = result.data.toModel()
                        userGrade.value = result.data.studentNumber.substring(0,1)
                        userClass.value = result.data.studentNumber.substring(1,2)
                        userNumber.value = result.data.studentNumber.substring(2,4)
                    }
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

    fun onClickLogout() = logoutEvent.call()

    fun onClickChangePassword() = changePasswordEvent.call()

    fun onClickEquipmentHistory() = equipmentHistoryEvent.call()

    fun onClickConfirmLogout() = logoutConfirmEvent.call()

    fun onClickCancelLogout() = logoutCancelEvent.call()

}