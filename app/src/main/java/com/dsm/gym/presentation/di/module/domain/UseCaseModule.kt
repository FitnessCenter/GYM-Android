package com.dsm.gym.presentation.di.module.domain

import PostDetailEquipmentUseCase
import com.dsm.gym.data.base.ErrorHandlerImpl
import com.dsm.gym.domain.base.ErrorHandler
import com.dsm.gym.domain.service.AuthService
import com.dsm.gym.domain.service.AuthServiceImpl
import com.dsm.gym.domain.service.EquipmentService
import com.dsm.gym.domain.service.EquipmentServiceImpl
import com.dsm.gym.domain.usecase.SignInUseCase
import com.dsm.gym.domain.usecase.SignUpUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SignUpUseCase(get(), get()) }
    factory { SignInUseCase(get(), get()) }
    factory { PostDetailEquipmentUseCase(get(), get()) }

    factory<ErrorHandler> { ErrorHandlerImpl() }

    factory<AuthService> { AuthServiceImpl(get(), get()) }
    factory<EquipmentService> { EquipmentServiceImpl(get(),get()) }
}