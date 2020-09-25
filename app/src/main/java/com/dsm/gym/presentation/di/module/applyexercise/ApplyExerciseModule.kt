package com.dsm.gym.presentation.di.module.applyexercise



import com.dsm.gym.data.datasource.ApplyExerciseDataSource
import com.dsm.gym.data.datasource.ApplyExerciseDataSourceImpl
import com.dsm.gym.data.repository.ApplyExerciseRepositoryImpl
import com.dsm.gym.domain.repository.ApplyExerciseRepository
import com.dsm.gym.domain.service.ApplyExerciseService
import com.dsm.gym.domain.service.ApplyExerciseServiceImpl
import com.dsm.gym.domain.usecase.ApplyExerciseUseCase
import com.dsm.gym.domain.usecase.CancelApplyExerciseUseCase
import com.dsm.gym.domain.usecase.GetAppliedExercisePersonnelUseCase
import com.dsm.gym.domain.usecase.GetApplyExerciseStateUseCase
import com.dsm.gym.presentation.viewmodel.applyexercise.ApplyExerciseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val applyExerciseModule: Module = module {
    viewModel { ApplyExerciseViewModel(get(),get(),get(),get()) }
    factory { ApplyExerciseUseCase(get(), get()) }
    factory { GetAppliedExercisePersonnelUseCase(get(), get()) }
    factory { GetApplyExerciseStateUseCase(get(), get()) }
    factory { CancelApplyExerciseUseCase(get(), get()) }
    factory<ApplyExerciseService> { ApplyExerciseServiceImpl(get(),get()) }
    factory<ApplyExerciseRepository> { ApplyExerciseRepositoryImpl(get()) }
    factory<ApplyExerciseDataSource> { ApplyExerciseDataSourceImpl(get()) }


}