package com.dsm.gym.presentation.di.module.account

import com.dsm.gym.data.datasource.AuthDataSource
import com.dsm.gym.data.datasource.AuthDataSourceImpl
import com.dsm.gym.data.repository.AuthRepositoryImpl
import com.dsm.gym.domain.repository.AuthRepository
import com.dsm.gym.domain.service.AuthService
import com.dsm.gym.domain.service.AuthServiceImpl
import com.dsm.gym.domain.usecase.SignInUseCase
import com.dsm.gym.domain.usecase.SignUpUseCase
import com.dsm.gym.presentation.viewmodel.signin.SignInViewModel
import com.dsm.gym.presentation.viewmodel.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val accountModule: Module = module {
    viewModel { SignUpViewModel(get()) }
    viewModel { SignInViewModel(get()) }

    factory<AuthDataSource> { AuthDataSourceImpl(get(), get()) }
    factory<AuthRepository> { AuthRepositoryImpl(get()) }
    factory { SignUpUseCase(get(), get()) }
    factory { SignInUseCase(get(), get()) }
    factory<AuthService> { AuthServiceImpl(get(), get()) }
}