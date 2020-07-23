package com.example.challengepicpay.presentation.feature.contacts

import com.example.challengepicpay.domain.model.ContactVO

sealed class ContactsViewState {
    data class Success(val contacts: List<ContactVO>) : ContactsViewState()
    data class Error(val throwable: Throwable) : ContactsViewState()
    data class Loading(val isLoading: Boolean) : ContactsViewState()
}