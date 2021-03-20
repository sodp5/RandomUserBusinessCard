package com.munny.randomuserbusinesscard.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.munny.randomuserbusinesscard.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {
    private val _mainState = MutableLiveData<MainState>(MainState())
    val mainState: LiveData<MainState>
        get() = _mainState

    data class MainState(
        val name: String = "",
        val company: String = "",
        val country: String = "",
        val city: String = "",
        val phone: String = "",
        val email: String = "",
        val isLoading: Boolean = false
    )

    fun requestRandomUser() {
        mainRepository.requestRandomUser()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                mainState.value?.let { state ->
                    _mainState.value = state.copy(
                        isLoading = true
                    )
                }
            }
            .doAfterTerminate {
                mainState.value?.let { state ->
                    _mainState.value = state.copy(
                        isLoading = false
                    )
                }
            }
            .subscribe { success ->
                success.results[0].let { result ->
                    mainState.value?.let { state ->
                        _mainState.value = state.copy(
                            name = result.name.let { "${it.title} ${it.first} ${it.last}" },
                            company = "RandomUser",
                            country = result.location.country,
                            city = result.location.city,
                            phone = result.phone,
                            email = result.email
                        )
                    }

                }
            }
            .also(this::addDisposable)
    }
}