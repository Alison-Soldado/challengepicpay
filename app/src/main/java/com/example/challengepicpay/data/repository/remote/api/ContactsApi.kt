package com.example.challengepicpay.data.repository.remote.api

import com.example.challengepicpay.data.repository.remote.response.ContactsResponse
import retrofit2.http.GET

interface ContactsApi {

    @GET("users")
    suspend fun contactsAsync() : List<ContactsResponse>
}