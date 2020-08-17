package com.dsm.gym.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel(){
    val createToastEvent = SingleLiveEvent<String>()

    fun MutableLiveData<String>.isNotValueBlank() = !this.isValueBlank()

    fun MutableLiveData<String>.isValueBlank() = this.value.isNullOrBlank()
}