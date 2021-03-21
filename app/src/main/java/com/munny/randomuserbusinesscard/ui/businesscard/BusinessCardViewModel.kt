package com.munny.randomuserbusinesscard.ui.businesscard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.munny.randomuserbusinesscard.base.BaseViewModel
import com.munny.randomuserbusinesscard.model.UserInfo
import javax.inject.Inject

class BusinessCardViewModel @Inject constructor() : BaseViewModel() {
    private val _businessCardState = MutableLiveData<BusinessCardState>()
    val businessCardState: LiveData<BusinessCardState>
        get() = _businessCardState

    data class BusinessCardState(
        val userInfo: UserInfo
    )

    fun setUserInfo(userInfo: UserInfo) {
        _businessCardState.value = BusinessCardState(userInfo)
    }
}