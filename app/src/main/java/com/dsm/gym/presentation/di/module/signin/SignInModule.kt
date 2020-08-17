package com.dsm.gym.presentation.di.module.signin

import com.dsm.gym.data.datasource.AuthDataSource
import com.dsm.gym.data.datasource.AuthDataSourceImpl
import com.dsm.gym.data.handler.AuthErrorHandlerImpl
import com.dsm.gym.data.local.pref.SharedPrefStorage
import com.dsm.gym.data.local.pref.SharedPrefStorageImpl
import com.dsm.gym.data.mapper.AuthDataMapper
import com.dsm.gym.data.mapper.TokenDataMapper
import com.dsm.gym.data.mapper.UserDataMapper
import com.dsm.gym.data.repository.AuthRepositoryImpl
import com.dsm.gym.domain.handler.AuthErrorHandler
import com.dsm.gym.domain.repository.AuthRepository
import com.dsm.gym.domain.service.AuthService
import com.dsm.gym.domain.service.AuthServiceImpl
import com.dsm.gym.domain.usecase.SignInUseCase
import com.dsm.gym.presentation.mapper.AuthMapper
import com.dsm.gym.presentation.viewmodel.signin.SignInViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val signInModule: Module = module {
    factory { UserDataMapper() }
    factory { TokenDataMapper() }
    factory { AuthDataMapper() }
    factory { AuthMapper() }
    factory<SharedPrefStorage> { SharedPrefStorageImpl(get()) }
    factory<AuthDataSource> { AuthDataSourceImpl(get(),get()) }
    factory<AuthRepository> { AuthRepositoryImpl(get(),get(),get(),get()) }
    single<AuthErrorHandler> { AuthErrorHandlerImpl() }
    factory<AuthService> { AuthServiceImpl(get(),get()) }
    factory { CompositeDisposable() }
    factory { SignInUseCase(get(),get()) }
    viewModel { SignInViewModel(get(), get()) }
}