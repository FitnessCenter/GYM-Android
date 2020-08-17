package com.dsm.gym.presentation.di.module

import com.dsm.gym.data.remote.Api
import com.dsm.gym.data.remote.AuthorizationInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single<Api> {
        Retrofit.Builder()
            .baseUrl("http:/dminside.kro.kr/api/")
            .client(
                OkHttpClient.Builder()
                .addInterceptor(AuthorizationInterceptor(get()))
                .addInterceptor(get<HttpLoggingInterceptor>())
                .build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}