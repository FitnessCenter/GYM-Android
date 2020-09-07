package com.dsm.gym.data.remote

import io.reactivex.Flowable
import com.dsm.gym.data.entity.*
import io.reactivex.Completable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("auth")
    fun signIn(@Body body: Any?): Flowable<TokenData>

    @POST("account")
    fun signUp(@Body body: Any?): Flowable<TokenData>

    @POST("/equipment-applies")
    fun postDetailEquipment(@Body body: Any?): Completable

    @GET("/equipment-applies")
    fun getAllEquipment(): Flowable<List<EquipmentData>>
}