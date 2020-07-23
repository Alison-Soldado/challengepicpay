package com.example.challengepicpay.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactVO(
    var img: String,
    var name: String,
    var id: Int,
    var username: String
) : Parcelable