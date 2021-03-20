package com.munny.randomuserbusinesscard.api

import com.munny.randomuserbusinesscard.api.response.RandomUserResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RandomUserApi {
    @GET("/api")
    fun requestRandomUser(): Single<RandomUserResponse>

    companion object {
        const val URL = "https://randomuser.me/"
    }
}