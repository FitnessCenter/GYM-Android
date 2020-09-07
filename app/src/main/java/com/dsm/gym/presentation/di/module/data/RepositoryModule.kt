package com.dsm.gym.presentation.di.module.data

import com.dsm.gym.data.repository.AuthRepositoryImpl
import com.dsm.gym.data.repository.EquipmentRepositoryImpl
import com.dsm.gym.domain.repository.AuthRepository
import com.dsm.gym.domain.repository.EquipmentRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<AuthRepository> { AuthRepositoryImpl(get(), get(), get(), get()) }
    factory<EquipmentRepository> { EquipmentRepositoryImpl(get(), get())  }
}