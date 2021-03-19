package com.munny.randomuserbusinesscard.ui

import android.util.Log
import com.munny.randomuserbusinesscard.base.BaseViewModel
import com.munny.randomuserbusinesscard.api.RandomUserApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {
    fun requestRandomUser() {
        mainRepository.requestRandomUser()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { success ->
                Log.d("TAGATAGTAG", "$success")
            }
            .also {
                compositeDisposable.add(it)
            }
    }
}