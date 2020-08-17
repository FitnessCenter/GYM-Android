package com.dsm.gym.presentation.di

import android.app.Application
import com.dsm.gym.presentation.di.module.networkModule
import com.dsm.gym.presentation.di.module.signin.signInModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication :Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(
                signInModule,
                networkModule)
            )
        }
    }
}
