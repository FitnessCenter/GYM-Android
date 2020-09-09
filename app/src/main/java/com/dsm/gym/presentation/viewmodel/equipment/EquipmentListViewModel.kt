package com.dsm.gym.presentation.viewmodel.equipment

import android.util.Log
import com.dsm.gym.domain.base.Result
import com.dsm.gym.domain.entity.EquipmentListEntity
import com.dsm.gym.domain.usecase.GetEquipmentUseCase
import com.dsm.gym.presentation.base.BaseViewModel
import io.reactivex.observers.DisposableSingleObserver

class EquipmentListViewModel(
    private val equipmentUseCase: GetEquipmentUseCase
): BaseViewModel(){

    fun getData(){
        Log.d("dfafd","aaaaaaa")
        equipmentUseCase.execute(Unit,object: DisposableSingleObserver<Result<List<EquipmentListEntity>>>(){
            override fun onSuccess(result: Result<List<EquipmentListEntity>>) {
                Log.d("dfdf","dfdfdf")
                Log.d("result",result.toString())
            }

            override fun onError(e: Throwable) {
                createToastEvent.value = "fail"
            }

        })
    }

    fun getSuccess(){
        Log.d("getSuccess","Success")
        createToastEvent.value = "성공"
    }

}