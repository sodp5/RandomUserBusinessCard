package com.munny.randomuserbusinesscard.ui.main

import com.munny.randomuserbusinesscard.api.model.RandomUserResponse
import com.munny.randomuserbusinesscard.ui.main.MainDataSource
import com.munny.randomuserbusinesscard.ui.main.MainRepository
import io.reactivex.Single
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
) : MainRepository {
    override fun requestRandomUser(): Single<RandomUserResponse> {
        return mainDataSource.requestRandomUser()
    }
}