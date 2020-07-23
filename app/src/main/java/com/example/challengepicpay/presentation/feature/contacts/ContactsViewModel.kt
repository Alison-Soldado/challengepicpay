package com.example.challengepicpay.presentation.feature.contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.challengepicpay.presentation.BaseViewModel
import com.example.challengepicpay.domain.usecase.GetContactsUseCase
import kotlinx.coroutines.launch

class ContactsViewModel(private val getContactsUseCase: GetContactsUseCase): BaseViewModel() {

    private val state = MutableLiveData<ContactsViewState>()
    val viewState: LiveData<ContactsViewState> = state

    fun contacts() {
        state.value = ContactsViewState.Loading(true)

        launch {
            try {
                state.value = ContactsViewState.Success(getContactsUseCase.getContacts())
                state.value = ContactsViewState.Loading(false)
            } catch (throwable: Throwable) {
                state.value = ContactsViewState.Error(throwable)
                state.value = ContactsViewState.Loading(false)
            }
        }
    }
}