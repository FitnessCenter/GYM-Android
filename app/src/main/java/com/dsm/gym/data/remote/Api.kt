package com.dsm.gym.data.remote

import io.reactivex.Flowable
import com.dsm.gym.data.entity.*
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @POST("users/accounts/auth")
    fun signIn(@Body body: Any?): Flowable<TokenData>

    @POST("users/accounts")
    fun signUp(@Body body: Any?): Flowable<TokenData>

    @POST("/exercise-applies/{time}/apply")
    fun applyExercise(@Path("time") time : Int) : Completable

    @POST("/exercise-applies/{time}/apply")
    fun getAppliedExercisePersonnel(@Path("time") time : Int) : Single<List<UserData>>
}