package com.dsm.gym.presentation.di.module.presentation.account



import com.dsm.gym.presentation.viewmodel.applyexercise.ApplyExerciseViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val applyExerciseModule: Module = module {
    single { ApplyExerciseViewModel(get(),get()) }
}