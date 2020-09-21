package com.dsm.gym.presentation.di.module.mypage


import com.dsm.gym.domain.usecase.ChangePasswordUseCase
import com.dsm.gym.presentation.viewmodel.mypage.ChangePasswordViewModel
import com.dsm.gym.presentation.viewmodel.mypage.MyPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val myPageModule: Module = module {
    viewModel { MyPageViewModel(get()) }
    viewModel { ChangePasswordViewModel(get()) }
    factory { ChangePasswordUseCase(get(),get()) }

}