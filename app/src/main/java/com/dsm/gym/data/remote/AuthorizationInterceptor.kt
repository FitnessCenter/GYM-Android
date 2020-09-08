package com.dsm.gym.data.remote

import com.dsm.gym.data.local.pref.SharedPrefStorage
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(private val pref: SharedPrefStorage): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", pref.getToken(true))
            .build()

        return chain.proceed(request)
    }
}