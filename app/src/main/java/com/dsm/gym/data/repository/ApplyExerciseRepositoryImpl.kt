package com.dsm.gym.data.repository

import com.dsm.gym.data.datasource.ApplyExerciseDataSource
import com.dsm.gym.data.entity.toEntity
import com.dsm.gym.domain.entity.ApplyExerciseEntity
import com.dsm.gym.domain.entity.UserInfoEntity
import com.dsm.gym.domain.repository.ApplyExerciseRepository
import io.reactivex.Completable
import io.reactivex.Single

class ApplyExerciseRepositoryImpl(private val dataSource: ApplyExerciseDataSource) : ApplyExerciseRepository {
    override fun applyExercise(time : Int): Completable = dataSource.applyExercise(time)
    override fun getAppliedExercisePersonnel(time: Int): Single<List<UserInfoEntity>> =
        dataSource.getAppliedExercisePersonnel(time)
            .map { it.map { list -> list.toEntity() } }

    override fun getApplyExerciseState(): Single<List<ApplyExerciseEntity>> = dataSource.getApplyExerciseState().map { it.map { it.toEntity()} }
    override fun cancelApplyExerciseState(): Completable = dataSource.cancelApplyExercise()

}