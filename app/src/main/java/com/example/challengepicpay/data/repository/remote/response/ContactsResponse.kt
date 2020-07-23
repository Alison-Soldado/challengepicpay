package com.example.challengepicpay.data.repository.remote.response

import com.google.gson.annotations.SerializedName

class ContactsResponse(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
)