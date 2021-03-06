package com.munny.randomuserbusinesscard.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.munny.randomuserbusinesscard.R
import com.munny.randomuserbusinesscard.base.BaseViewModel
import com.munny.randomuserbusinesscard.model.UserInfo
import com.munny.randomuserbusinesscard.util.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {
    private val _mainState = MutableLiveData<MainState>()
    val mainState: LiveData<MainState>
        get() = _mainState

    private val _mainCommand = MutableLiveData<Event<MainCommand>>()
    val mainCommand: LiveData<Event<MainCommand>>
        get() = _mainCommand

    data class MainState(
        val userInfo: UserInfo? = null,
        val isLoading: Boolean = false
    )

    sealed class MainCommand {
        data class CreateBusinessCard(val userInfo: UserInfo) : MainCommand()
        data class ShowToast(val messageId: Int) : MainCommand()
    }

    init {
        _mainState.value = MainState()
    }

    fun requestRandomUser() {
        mainRepository.requestRandomUser()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                _mainState.value = mainState.value?.copy(isLoading = true)
            }
            .doAfterTerminate {
                _mainState.value = mainState.value?.copy(
                    isLoading = false
                )
            }
            .subscribe { success ->
                success.results[0].let { result ->
                    _mainState.value = mainState.value?.copy(
                        userInfo = UserInfo(
                            name = result.name.let { "${it.title} ${it.first} ${it.last}" },
                            company = "RandomUser",
                            country = result.location.country,
                            city = result.location.city,
                            phone = result.phone,
                            email = result.email,
                            imageUrl = result.picture.medium
                        )
                    )
                }
            }
            .also(this::addDisposable)
    }

    fun createBusinessCard() {
        _mainCommand.value = mainState.value?.userInfo?.let { userInfo ->
            Event(MainCommand.CreateBusinessCard(userInfo))
        } ?: Event(MainCommand.ShowToast(R.string.main_request_random_user_toast))
    }
}