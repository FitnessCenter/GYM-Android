package com.dsm.gym.data.remote

import io.reactivex.Flowable
import com.dsm.gym.data.entity.*
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("users/accounts/auth")
    fun signIn(@Body body: Any?): Flowable<TokenData>

    @POST("signup")
    fun signUp(@Body body: Any?): Flowable<TokenData>
}