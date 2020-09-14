package com.dsm.gym.presentation.di.module.home

import com.dsm.gym.data.datasource.HomePageDataSource
import com.dsm.gym.data.datasource.HomePageDataSourceImpl
import com.dsm.gym.data.repository.HomePageRepositoryImpl
import com.dsm.gym.domain.repository.HomePageRepository
import com.dsm.gym.domain.service.HomePageService
import com.dsm.gym.domain.service.HomePageServiceImpl
import com.dsm.gym.domain.usecase.GetNumOfDaysExerciseUseCase
import com.dsm.gym.presentation.viewmodel.home.HomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val homeModule: Module = module {
    viewModel { HomePageViewModel(get()) }

    factory<HomePageDataSource> { HomePageDataSourceImpl(get())  }
    factory<HomePageRepository> { HomePageRepositoryImpl(get())  }
    factory { GetNumOfDaysExerciseUseCase(get(), get()) }
    factory<HomePageService> { HomePageServiceImpl(get(),get()) }
}