package com.dsm.gym.presentation.viewmodel.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.ExerciseDayEntity
import com.dsm.gym.domain.entity.ExerciseTimeEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.usecase.GetApplyTimeUseCase
import com.dsm.gym.domain.usecase.GetNumOfDaysExerciseUseCase
import com.dsm.gym.domain.usecase.GetUserInfoUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.model.ExerciseTimeModel
import io.reactivex.observers.DisposableSingleObserver
import java.util.*

class HomePageViewModel(
    private val getNumOfDaysExerciseUseCase: GetNumOfDaysExerciseUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val getApplyTimeUseCase: GetApplyTimeUseCase
) : BaseViewModel() {
    val userNameText = MutableLiveData<String>()
    val exerciseTimeText = MutableLiveData<String>()
    val numOfDaysExerciseText = MutableLiveData<String>("0")
    val randomText = MutableLiveData<String>()

    init {
        getUserInfo()
        getNumOfDaysExercise()
        getApplyTime()
        randomText()
    }

    private fun getNumOfDaysExercise() {
        getNumOfDaysExerciseUseCase.execute(Unit, object : DisposableSingleObserver<Result<ExerciseDayEntity>>() {
            override fun onSuccess(result: Result<ExerciseDayEntity>) {
                when (result) {
                    is Result.Success -> numOfDaysExerciseText.value = result.data.numOfExerciseDay.toString()
                    is Result.Error -> when (result.message) {
                        Message.SERVER_ERROR -> createToastEvent.value = "서버 오류가 발생했습니다"

                        Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다"

                        else -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"
                    }
                }
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 오가 발생했습니다"
            }
        })
    }

    private fun getUserInfo() {
        getUserInfoUseCase.execute(Unit, object : DisposableSingleObserver<Result<UserInfoEntity>>(){
            override fun onSuccess(result: Result<UserInfoEntity>) {
                when(result){
                    is Result.Success -> userNameText.value = result.data.studentName
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

    private fun getApplyTime() {
        getApplyTimeUseCase.execute(Unit, object : DisposableSingleObserver<Result<ExerciseTimeEntity>>(){
            override fun onSuccess(result: Result<ExerciseTimeEntity>) {
                when(result){
                    is Result.Success -> getTimeSuccess(result.data.applyTime)
                    is Result.Error -> when(result.message){
                        Message.NOT_FOUND -> exerciseTimeText.value = "현재 미신청 상태입니다."

                        Message.SERVER_ERROR -> createToastEvent.value = "서버 오류가 발생했습니다"

                        Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다"

                        else -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"
                    }
                }
            }

            override fun onError(e: Throwable) {

            }

        })
    }

    private fun getTimeSuccess(applyTime: Int){
        when(applyTime){
            0 -> exerciseTimeText.value = "9 : 30 ~ 10 : 00에 \n 운동을 신청하셨습니다."
            1 -> exerciseTimeText.value = "10 : 00 ~ 10 : 30에 \n 운동을 신청하셨습니다."
            2 -> exerciseTimeText.value = "10 : 30 ~ 11 : 00에 \n 운동을 신청하셨습니다."
        }
    }

    private fun randomText(){
        val random =  Random()
        when(random.nextInt(7)){
            0 -> randomText.value = "뭘 봐 ,운동이나 해"
            1 -> randomText.value = "울지마라 근손실 나니까"
            2 -> randomText.value = "무지방 상팔자"
            3 -> randomText.value = "넌 운동할 때가 제일 이뻐"
            4 -> randomText.value = "익숙함에 속아 내 뱃살을 잊지 말자"
            5 -> randomText.value = "한눈팔면 허리 나감"
            6 -> randomText.value = "NO PAIN NO GAIN"
        }
    }
}