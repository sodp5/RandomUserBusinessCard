package com.munny.randomuserbusinesscard.ui

import com.munny.randomuserbusinesscard.api.model.RandomUserResponse
import io.reactivex.Single

interface MainRepository {
    fun requestRandomUser(): Single<RandomUserResponse>
}