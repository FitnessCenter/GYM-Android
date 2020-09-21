package com.dsm.gym.data.remote

import com.dsm.gym.data.entity.*
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface Api {
    @POST("auth")
    fun signIn(@Body body: Any?): Single<TokenData>

    @POST("account")
    fun signUp(@Body body: Any?): Completable

    @POST("/equipment-applies")
    fun postDetailEquipment(@Body body: Any?): Completable

    @GET("/equipment-applies")
    fun getAllEquipment(): Single<List<EquipmentListData>>

    @GET("/exercise-applies/my/number-of-days-exercised")
    fun getNumOfDaysExercised(): Single<ExerciseDayData>

    @GET("/account")
    fun getUserInfo(): Single<UserInfoData>

    @GET("/exercise-applies/my")
    fun getApplyTime(): Single<ExerciseTimeData>

    @POST("/exercise-applies/{time}/apply")
    fun applyExercise(@Path("time") time : Int) : Completable

    @GET("/exercise-applies/{time}/appliers")
    fun getAppliedExercisePersonnel(@Path("time") time : Int) : Single<List<UserInfoData>>

    @GET("/exercise-applies")
    fun getApplyExerciseState() : Single<List<ApplyExerciseData>>

    @DELETE("/exercise-applies/my")
    fun cancelApplyExercise() : Completable


}