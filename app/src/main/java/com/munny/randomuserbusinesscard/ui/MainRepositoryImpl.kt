package com.munny.randomuserbusinesscard.ui

import com.munny.randomuserbusinesscard.api.model.RandomUserResponse
import io.reactivex.Single
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
) : MainRepository {
    override fun requestRandomUser(): Single<RandomUserResponse> {
        return mainDataSource.requestRandomUser()
    }
}