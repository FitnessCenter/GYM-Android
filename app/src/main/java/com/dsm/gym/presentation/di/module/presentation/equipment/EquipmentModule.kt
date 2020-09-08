package com.dsm.gym.presentation.di.module.presentation.equipment

import com.dsm.gym.presentation.viewmodel.equipment.EquipmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val equipmentModule: Module = module {
    viewModel { EquipmentViewModel(get()) }
}