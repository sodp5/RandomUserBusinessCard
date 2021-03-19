package com.munny.randomuserbusinesscard.ui.main

import com.munny.randomuserbusinesscard.api.RandomUserApi
import com.munny.randomuserbusinesscard.api.model.RandomUserResponse
import io.reactivex.Single
import javax.inject.Inject

class MainDataSource @Inject constructor(
    private val randomUserApi: RandomUserApi
) {
    fun requestRandomUser(): Single<RandomUserResponse> {
        return randomUserApi.requestRandomUser()
    }
}