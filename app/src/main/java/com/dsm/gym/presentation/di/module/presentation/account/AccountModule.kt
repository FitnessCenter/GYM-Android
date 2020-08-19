package com.dsm.gym.presentation.di.module.presentation.account

import com.dsm.gym.presentation.viewmodel.signin.SignInViewModel
import com.dsm.gym.presentation.viewmodel.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val accountModule: Module = module {
    viewModel { SignUpViewModel(get(), get()) }
    viewModel { SignInViewModel(get(), get()) }
}