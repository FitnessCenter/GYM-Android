package com.dsm.gym.presentation.di

import android.app.Application
import com.dsm.gym.presentation.di.module.networkModule
import com.dsm.gym.presentation.di.module.presentation.account.accountModule
import com.dsm.gym.presentation.di.module.data.dataModule
import com.dsm.gym.presentation.di.module.data.repositoryModule
import com.dsm.gym.presentation.di.module.domain.useCaseModule
import com.dsm.gym.presentation.di.module.presentation.equipment.equipmentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    accountModule,
                    networkModule,
                    equipmentModule,

                    repositoryModule,
                    dataModule,
                    useCaseModule
                )
            )
        }
    }
}
