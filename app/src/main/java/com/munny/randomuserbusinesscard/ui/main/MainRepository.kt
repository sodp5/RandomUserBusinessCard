package com.munny.randomuserbusinesscard.ui.main

import com.munny.randomuserbusinesscard.api.model.RandomUserResponse
import io.reactivex.Single

interface MainRepository {
    fun requestRandomUser(): Single<RandomUserResponse>
}