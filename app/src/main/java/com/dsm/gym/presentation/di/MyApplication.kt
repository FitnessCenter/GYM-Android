package com.dsm.gym.presentation.di

import android.app.Application
import com.dsm.gym.presentation.di.module.networkModule
import com.dsm.gym.presentation.di.module.account.accountModule
import com.dsm.gym.presentation.di.module.equipment.equipmentModule
import com.dsm.gym.presentation.di.module.home.homeModule
import com.dsm.gym.presentation.di.module.mypage.myPageModule
import com.dsm.gym.presentation.di.module.util.utilModule
import com.dsm.gym.presentation.di.module.applyexercise.applyExerciseModule
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
                    homeModule,
                    applyExerciseModule,
                    myPageModule,
                    utilModule
                )
            )
        }
    }
}
