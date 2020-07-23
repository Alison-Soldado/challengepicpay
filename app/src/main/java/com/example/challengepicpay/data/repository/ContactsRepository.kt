package com.example.challengepicpay.data.repository

import com.example.challengepicpay.domain.usecase.GetContactsUseCase
import com.example.challengepicpay.data.repository.remote.api.ContactsApi
import com.example.challengepicpay.data.repository.remote.mapper.toValueObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository(private val contactsApi: ContactsApi) : GetContactsUseCase {
    override suspend fun getContacts() = withContext(Dispatchers.IO) {
        contactsApi.contactsAsync().toValueObject()
    }
}