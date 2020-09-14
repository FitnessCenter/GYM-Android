package com.dsm.gym.presentation.viewmodel.signup

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.dsm.gym.R
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.usecase.SignUpUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import com.dsm.gym.presentation.model.UserModel
import com.dsm.gym.presentation.model.toEntity
import io.reactivex.observers.DisposableSingleObserver


class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
) : BaseViewModel() {
    val studentNumberText = MutableLiveData<String>()
    val studentNameText = MutableLiveData<String>()
    val idText = MutableLiveData<String>()
    val passwordText = MutableLiveData<String>()
    val passwordCheckText = MutableLiveData<String>()
    var sex = MutableLiveData<Boolean>()

    val btnNextClickable = MediatorLiveData<Boolean>().apply {
        addSource(studentNumberText) { value = checkFirstFullText() }
        addSource(studentNameText) { value = checkFirstFullText() }
    }
    val btnFinishClickable = MediatorLiveData<Boolean>().apply {
        addSource(idText) { value = checkCompleteFullText() }
        addSource(passwordText) { value = checkCompleteFullText() }
        addSource(passwordCheckText) { value =  checkCompleteFullText() }
    }

    val startSecondSignUpEvent = SingleLiveEvent<Unit>()
    val startSignInEvent = SingleLiveEvent<Unit>()
    val startCompleteSignUpEvent = SingleLiveEvent<Unit>()

    val passwordErrorEvent = SingleLiveEvent<String>()
    val passwordCheckErrorEvent = SingleLiveEvent<String>()

    private fun checkFirstFullText(): Boolean =
        studentNumberText.isNotValueBlank() && studentNameText.isNotValueBlank()

    private fun checkCompleteFullText(): Boolean =
        idText.isNotValueBlank() && passwordText.isNotValueBlank() && passwordCheckText.isNotValueBlank()

    fun clickSignUpNext() {
        startSecondSignUpEvent.call()
    }

    private fun signUp(user: UserModel) {
        signUpUseCase.execute(user.toEntity(), object : DisposableSingleObserver<Result<Unit>>() {
            override fun onSuccess(result: Result<Unit>) {
                when (result) {
                    is Result.Success -> onSuccessSignUp()
                    is Result.Error -> onErrorSignUp(result)
                }
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다"
            }

        })
    }

    private fun onSuccessSignUp() {
        startCompleteSignUpEvent.call()
    }

    private fun onErrorSignUp(result: Result.Error<Unit>) {
        when(result.message) {
            Message.SERVER_ERROR -> {
                createToastEvent.value = "서버 오류가 발생했습니다"
            }
            Message.NETWORK_ERROR -> {
                createToastEvent.value = "네트워크 오류가 발생했습니다"
            }
            Message.UNKNOWN_ERROR -> {
                createToastEvent.value = "알 수 없는 오류가 발생했습니다"
            }
            Message.CONFLICT -> {
                createToastEvent.value = "존재하는 유저입니다"
            }
            else ->{
                createToastEvent.value = "알 수 없는 오류가 발생했습니다"
            }
        }
    }

    fun clickSignUpFinish() {
        if (passwordText.value != passwordCheckText.value) {
            passwordErrorEvent.value = "비밀번호와 비밀번호 확인이 일치하지 않습니다"
            passwordCheckErrorEvent.value = "비밀번호와 비밀번호 확인이 일치하지 않습니다"
        } else {
            signUp(
                UserModel(
                    studentNumber = studentNumberText.value!!,
                    studentName = studentNameText.value!!,
                    id = idText.value!!,
                    password = passwordText.value!!,
                    sex = sex.value!!
                )
            )
        }
    }

    fun clickSignUpComplete(){
        startSignInEvent.call()
    }

    fun onSplitTypeChanged(id: Int) {
        when(id){
            R.id.register_man_radio_btn -> sex.value = true
            R.id.register_woman_radio_btn -> sex.value = false
        }
    }

}