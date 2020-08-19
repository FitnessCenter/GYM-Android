package com.dsm.gym.presentation.viewmodel.signup

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.ErrorHandlerEntity
import com.dsm.gym.domain.entity.TokenEntity
import com.dsm.gym.domain.usecase.SignUpUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import com.dsm.gym.presentation.mapper.UserMapper
import com.dsm.gym.presentation.model.UserModel
import io.reactivex.subscribers.DisposableSubscriber


class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase,
    private val userMapper: UserMapper
) : BaseViewModel() {
    val studentNumberText = MutableLiveData<String>()
    val studentNameText = MutableLiveData<String>()
    val idText = MutableLiveData<String>()
    val passwordText = MutableLiveData<String>()
    val passwordCheckText = MutableLiveData<String>()
    val sex = MutableLiveData<Int>()

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

//    fun onRadioButtonClicked(v: View){
//        Log.d("gd","dfd")
//        when(v.id){
//            R.id.register_man_radio_btn -> sex.postValue(1)
//            R.id.register_woman_radio_btn -> sex.postValue(0)
//        }
//    }

    fun clickSignUpNext() {
        startSecondSignUpEvent.call()
    }

    private fun signUp(user: UserModel) {
        signUpUseCase.execute(userMapper.mapFrom(user), object: DisposableSubscriber<Pair<TokenEntity, ErrorHandlerEntity>>() {
            override fun onNext(t: Pair<TokenEntity, ErrorHandlerEntity>) {
                if (t.second.isSuccess) signUpSuccess()
                else signUpFail(t.second.message)
            }
            override fun onComplete() {

            }
            override fun onError(t: Throwable) {
                createToastEvent.value = "오 발생"
            }
        })
    }

    fun signUpSuccess() {
        createToastEvent.value = "회원가입 되었습니다"
        startCompleteSignUpEvent.call()
    }

    fun signUpFail(message: String) {
        createToastEvent.value = message
    }

    fun clickSignUpFinish() {
        if (passwordText.value != passwordCheckText.value) {
            passwordErrorEvent.value = "비밀번호와 비밀번호 확인이 일치하지 않습니다"
            passwordCheckErrorEvent.value = "비밀번호와 비밀번호 확인이 일치하지 않습니다"
        } else {
            signUp(UserModel(
                studentNumber = studentNumberText.value!!,
                studentName = studentNameText.value!!,
                id = idText.value!!,
                password = passwordText.value!!,
                sex = true
            ))
            startCompleteSignUpEvent.call()
        }
    }

    fun clickSignUpComplete(){
        startSignInEvent.call()
    }
}