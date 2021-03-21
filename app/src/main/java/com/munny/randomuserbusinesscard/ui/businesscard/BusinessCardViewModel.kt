package com.munny.randomuserbusinesscard.ui.businesscard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.munny.randomuserbusinesscard.base.BaseViewModel
import com.munny.randomuserbusinesscard.di.viewmodel.ViewModelFactory
import com.munny.randomuserbusinesscard.model.UserInfo
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class BusinessCardViewModel @AssistedInject constructor(
    @Assisted userInfo: UserInfo
) : BaseViewModel() {
    private val _businessCardState = MutableLiveData<BusinessCardState>(BusinessCardState(userInfo))
    val businessCardState: LiveData<BusinessCardState>
        get() = _businessCardState

    data class BusinessCardState(
        val userInfo: UserInfo
    )

    @AssistedFactory
    interface BusinessCardViewModelFactory {
        fun create(userInfo: UserInfo): BusinessCardViewModel
    }
    companion object {
        fun getBusinessCardViewModelFactory(factory: BusinessCardViewModelFactory, userInfo: UserInfo) =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return factory.create(userInfo) as T
                }
            }
    }
}