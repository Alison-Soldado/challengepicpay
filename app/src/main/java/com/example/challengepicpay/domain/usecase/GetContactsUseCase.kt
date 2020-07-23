package com.example.challengepicpay.domain.usecase

import com.example.challengepicpay.domain.model.ContactVO

interface GetContactsUseCase {
    suspend fun getContacts() : List<ContactVO>
}