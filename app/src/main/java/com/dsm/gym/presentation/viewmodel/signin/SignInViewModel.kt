package com.dsm.gym.presentation.viewmodel.signin

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.usecase.SignInUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import com.dsm.gym.presentation.model.AuthModel
import com.dsm.gym.presentation.model.toEntity
import io.reactivex.observers.DisposableSingleObserver

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : BaseViewModel() {
    val idText = MutableLiveData<String>()
    val passwordText = MutableLiveData<String>()
    val btnClickable = MediatorLiveData<Boolean>().apply {
        addSource(idText) { value = checkFullText() }
        addSource(passwordText) { value = checkFullText() }
    }

    val startMainEvent = SingleLiveEvent<Unit>()
    val startSignUpEvent = SingleLiveEvent<Unit>()
    val idErrorEvent = SingleLiveEvent<String>()
    val passwordErrorEvent = SingleLiveEvent<String>()

    fun clickLogin() {
        val auth = AuthModel(idText.value!!, passwordText.value!!)
        Log.d("click", auth.toString())

        signInUseCase.execute(
            auth.toEntity(), object : DisposableSingleObserver<Result<Unit>>() {
                override fun onSuccess(result: Result<Unit>) {
                    when (result) {
                        is Result.Success -> onSuccessSignIn()
                        is Result.Error -> onErrorSignIn(result)
                    }
                }

                override fun onError(e: Throwable) {
                    idErrorEvent.value = "알 수 없는 오류가 발생했습니다"
                    passwordErrorEvent.value = "알 수 없는 오류가 발생했습니다"
                }
            }
        )
    }

    fun clickSignUp() {
        startSignUpEvent.call()
    }

    private fun onSuccessSignIn() {
        createToastEvent.value = "로그인 되었습니다"
        startMainEvent.call()
    }

    private fun onErrorSignIn(result: Result.Error<Unit>) {
        when(result.message) {
            Message.SERVER_ERROR ->{
                idErrorEvent.value = "서버 오류가 발생했습니다"
                passwordErrorEvent.value = "서버 오류가 발생했습니다"
            }
            Message.NETWORK_ERROR -> {
                idErrorEvent.value = "네트워크 오류가 발생했습니다"
                passwordErrorEvent.value = "네트워크 오류가 발생했습니다"
            }
            Message.UNKNOW_ERROR -> {
                idErrorEvent.value = "알 수 없는 오류가 발생했습니다"
                passwordErrorEvent.value = "알 수 없는 오류가 발생했습니다"
            }
            Message.UNAUTHORIZED -> {
                createToastEvent.value = "존재하지 않는 유저입니다"
            }
            else ->{
                idErrorEvent.value = "알 수 없는 오류가 발생했습니다"
                passwordErrorEvent.value = "알 수 없는 오류가 발생했습니다"
            }
        }
    }

    private fun checkFullText(): Boolean =
        idText.isNotValueBlank() && passwordText.isNotValueBlank()
}