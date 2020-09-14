package com.dsm.gym.presentation.viewmodel.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.base.Message
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.ExerciseTimeEntity
import com.dsm.gym.domain.entity.toModel
import com.dsm.gym.domain.usecase.GetNumOfDaysExerciseUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.model.ExerciseTimeModel
import io.reactivex.observers.DisposableSingleObserver

class HomePageViewModel(
    private val useCase: GetNumOfDaysExerciseUseCase
) : BaseViewModel() {
    val userNameText = MutableLiveData<String>()
    val exerciseTimeText = MutableLiveData<String>()
    val numOfDaysExerciseText = MutableLiveData<String>("0")
    val randomText = MutableLiveData<String>()

    init {
        Log.d("log",numOfDaysExerciseText.value!!)
        getNumOfDaysExercise()
    }

    private fun getNumOfDaysExercise() {
        useCase.execute(Unit, object : DisposableSingleObserver<Result<ExerciseTimeEntity>>() {
            override fun onSuccess(result: Result<ExerciseTimeEntity>) {
                when (result) {
                    is Result.Success -> getSuccess(result.data.toModel())
                    is Result.Error -> getFail(result)
                }
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "알 수 없는 에러가 발생했습니다"
            }
        })
    }

    fun getSuccess(result: ExerciseTimeModel) {
        Log.d("success",result.toString())
        numOfDaysExerciseText.value = result.exerciseTime.toString()
    }

    fun getFail(result: Result.Error<ExerciseTimeEntity>) {
        when (result.message) {
            Message.SERVER_ERROR -> createToastEvent.value = "서버 오류가 발생했습니다"

            Message.NETWORK_ERROR -> createToastEvent.value = "네트워크 오류가 발생했습니다"

            Message.UNKNOWN_ERROR -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"

            Message.UNAUTHORIZED -> createToastEvent.value = "존재하지 않는 유저입니다"

            else -> createToastEvent.value = "알 수 없는 오류가 발생했습니다"
        }
    }

}