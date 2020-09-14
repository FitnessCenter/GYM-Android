package com.dsm.gym.data.remote

import com.dsm.gym.data.entity.*
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @POST("auth")
    fun signIn(@Body body: Any?): Single<TokenData>

    @POST("account")
    fun signUp(@Body body: Any?): Completable

    @POST("/equipment-applies")
    fun postDetailEquipment(@Body body: Any?): Completable

    @GET("/equipment-applies")
    fun getAllEquipment(): Single<List<EquipmentListData>>
    @POST("users/accounts")
    fun signUp(@Body body: Any?): Flowable<TokenData>

    @POST("/exercise-applies/{time}/apply")
    fun applyExercise(@Path("time") time : Int) : Completable

    @POST("/exercise-applies/{time}/apply")
    fun getAppliedExercisePersonnel(@Path("time") time : Int) : Single<List<UserData>>
}