package com.dsm.gym.presentation.viewmodel.applyexercise

import androidx.lifecycle.MutableLiveData
import com.dsm.gym.domain.usecase.ApplyExerciseUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import com.dsm.gym.presentation.base.SingleLiveEvent
import io.reactivex.observers.DisposableSingleObserver
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.UserEntity
import com.dsm.gym.domain.usecase.GetAppliedExercisePersonnelUsecase
import org.koin.ext.getScopeName

class ApplyExerciseViewModel(private val applyExerciseUseCase: ApplyExerciseUseCase,
                             private val getAppliedExercisePersonnelUsecase: GetAppliedExercisePersonnelUsecase) : BaseViewModel() {
    val applyExerciseEvent = SingleLiveEvent<String>()
    val applyExerciseTime = MutableLiveData<Int>()
    val appliedExercisePersonnelEvent = SingleLiveEvent<Unit>()
    val dismissDialogEvent = SingleLiveEvent<Unit>()


    fun nineThirtyApplyExercise() {
        applyExerciseEvent.value = "9 : 30 ~ 10 : 00"
        applyExerciseTime.value = 1
    }
    fun tenApplyExercise(){
        applyExerciseEvent.value= "10 : 00 ~ 10 : 30"
        applyExerciseTime.value = 2
    }
    fun tenThirtyApplyExercise(){
        applyExerciseEvent.value= "10 : 30 ~ 11 : 00"
        applyExerciseTime.value = 3
    }

    fun showGetAppliedExercisePersonnel(){
        getAppliedExercisePersonnel()
    }
    fun getApplyExerciseState(){

    }
    fun getAppliedExercisePersonnel(){
        getAppliedExercisePersonnelUsecase.execute(applyExerciseTime.value!!, object : DisposableSingleObserver<Result<List<UserEntity>>>(){
            override fun onSuccess(result: Result<List<UserEntity>>) {
                when(result){
                    is Result.Success ->{

                    }
                    is Result.Error ->{

                    }
                }
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
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

                    }
                    is Result.Error->{
                        when(result.message){


                        }

                    }
                }

            }

            override fun onError(e: Throwable) {
            }

        }
        )


    }
}