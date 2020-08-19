package com.dsm.gym.presentation.viewmodel.signin

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.usecase.SignInUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import com.dsm.gym.presentation.mapper.AuthMapper
import com.dsm.gym.presentation.model.AuthModel
import io.reactivex.subscribers.DisposableSubscriber

class SignInViewModel(
    private val signInUseCase: SignInUseCase,
    private val authMapper: AuthMapper
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
        Log.d("click",auth.toString())

        signInUseCase.execute(authMapper.mapFrom(auth),object : DisposableSubscriber<Pair<TokenEntity, ErrorHandlerEntity>>(){
            override fun onNext(t: Pair<TokenEntity, ErrorHandlerEntity>) {
                if(t.second.isSuccess) {
                    loginSuccess()
                    Log.d("loginSuccess","loginSuccess")
                }
                else {
                    loginFail(t.second.message)
                    Log.d("loginFail",t.toString())
                }
            }

            override fun onComplete() {

            }

            override fun onError(t: Throwable?) {
                createToastEvent.value = "오류 발생"
            }
        })
    }

    fun clickSignUp() {
        startSignUpEvent.call()
    }

    fun loginSuccess() {
        createToastEvent.value = "로그인 되었습니다"
        startMainEvent.call()
    }

    fun loginFail(message: String) {
        idErrorEvent.value = message
        passwordErrorEvent.value = message
    }

    private fun checkFullText(): Boolean =
        idText.isNotValueBlank() && passwordText.isNotValueBlank()
}