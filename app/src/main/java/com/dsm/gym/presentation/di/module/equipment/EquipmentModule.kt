package com.dsm.gym.presentation.di.module.equipment

import com.dsm.gym.data.datasource.EquipmentDataSource
import com.dsm.gym.data.datasource.EquipmentDataSourceImpl
import com.dsm.gym.data.repository.EquipmentRepositoryImpl
import com.dsm.gym.domain.repository.EquipmentRepository
import com.dsm.gym.domain.service.EquipmentService
import com.dsm.gym.domain.service.EquipmentServiceImpl
import com.dsm.gym.domain.usecase.GetEquipmentUseCase
import com.dsm.gym.domain.usecase.PostDetailEquipmentUseCase
import com.dsm.gym.presentation.viewmodel.equipment.EquipmentDetailViewModel
import com.dsm.gym.presentation.viewmodel.equipment.EquipmentListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val equipmentModule: Module = module {
    viewModel { EquipmentDetailViewModel(get()) }
    viewModel { EquipmentListViewModel(get()) }

    factory<EquipmentDataSource> { EquipmentDataSourceImpl(get())  }
    factory<EquipmentRepository> { EquipmentRepositoryImpl(get())  }
    factory { PostDetailEquipmentUseCase(get(), get()) }
    factory { GetEquipmentUseCase(get(),get()) }
    factory<EquipmentService> { EquipmentServiceImpl(get(),get()) }
}