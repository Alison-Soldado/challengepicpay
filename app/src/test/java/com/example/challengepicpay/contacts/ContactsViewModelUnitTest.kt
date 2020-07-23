package com.example.challengepicpay.contacts

import androidx.lifecycle.Observer
import com.example.challengepicpay.instantLiveDataAndCoroutinesRule
import com.example.challengepicpay.presentation.feature.contacts.ContactsViewModel
import com.example.challengepicpay.presentation.feature.contacts.ContactsViewState
import com.example.challengepicpay.domain.model.ContactVO
import com.example.challengepicpay.domain.usecase.GetContactsUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ContactsViewModelUnitTest {

    @get:Rule
    val rule = instantLiveDataAndCoroutinesRule

    private val observer : Observer<ContactsViewState> = mock()

    private val contactsVO: List<ContactVO> = contactsVOMock()
    private val isLoadingTrue: Boolean = true
    private val isLoadingFalse: Boolean = false
    private val throwable: Throwable = mock()

    private val getContactsUseCase: GetContactsUseCase = mock()

    private val viewModel = ContactsViewModel(getContactsUseCase)

    @Before
    fun setup() {
        viewModel.viewState.observeForever(observer)
    }

    @Test
    fun givenResponseContactsVO_WhenRequestContacts_ThenReturnSuccess() {
        whenever(runBlocking { getContactsUseCase.getContacts() }) doReturn contactsVO

        viewModel.contacts()

        verify(observer, times(1)).onChanged(ContactsViewState.Loading(isLoadingTrue))
        verify(observer, times(1)).onChanged(ContactsViewState.Success(contactsVO))
        verify(observer, times(1)).onChanged(ContactsViewState.Loading(isLoadingFalse))
        verify(observer, never()).onChanged(ContactsViewState.Error(throwable))

        verifyNoMoreInteractions(observer)
    }

    @Test
    fun givenResponseContactsVO_WhenRequestContacts_ThenReturnSuccessEmpty() {
        whenever(runBlocking { getContactsUseCase.getContacts() }) doReturn emptyList()

        viewModel.contacts()

        verify(observer, times(1)).onChanged(ContactsViewState.Loading(isLoadingTrue))
        verify(observer, times(1)).onChanged(ContactsViewState.Success(emptyList()))
        verify(observer, times(1)).onChanged(ContactsViewState.Loading(isLoadingFalse))
        verify(observer, never()).onChanged(ContactsViewState.Error(throwable))

        verifyNoMoreInteractions(observer)
    }
}