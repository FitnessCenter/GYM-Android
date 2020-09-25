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

    @GET("/equipment-applies")
    fun getMyEquipment(@Query("whose") whose: String): Single<List<EquipmentListData>>


    @DELETE("/equipment-applies/{equipment_apply_id}")
    fun cancelMyEquipment(@Path("equipment_apply_id") equipmentApplyId: Int): Completable

    @GET("/exercise-applies/my/number-of-days-exercised")
    fun getNumOfDaysExercised(): Single<ExerciseDayData>

    @GET("/account")
    fun getUserInfo(): Single<UserInfoData>

    @GET("/exercise-applies/my")
    fun getApplyTime(): Single<ExerciseTimeData>

    @PUT("/account")
    fun changePassword(@Body passwordData : ChangePasswordData): Completable

}