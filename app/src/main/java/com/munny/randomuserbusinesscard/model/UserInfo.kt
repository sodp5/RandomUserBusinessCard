package com.munny.randomuserbusinesscard.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfo(
    val name: String = "",
    val company: String = "",
    val country: String = "",
    val city: String = "",
    val phone: String = "",
    val email: String = "",
    val imageUrl: String? = null
) : Parcelable