package com.example.challengepicpay.contacts

import com.example.challengepicpay.domain.model.ContactVO
import com.example.challengepicpay.data.repository.remote.api.ContactsApi
import com.example.challengepicpay.data.repository.remote.response.ContactsResponse
import com.example.challengepicpay.data.repository.ContactsRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ContactsRepositoryUnitTest {

    private val contactsVO: List<ContactVO> = contactsVOMock()
    private val contactsResponse: List<ContactsResponse> = contactsResponseMock()
    private val contactApi: ContactsApi = mock()
    private val contactsRepository =
        ContactsRepository(contactApi)

    @Test
    fun givenResponseContacts_WhenGetContactsVO_ThenAssertEquals() {
        whenever(runBlocking { contactApi.contactsAsync() }) doReturn contactsResponse
        val result = runBlocking { contactsRepository.getContacts() }
        assertEquals(contactsVO, result)
    }

    @Test
    fun givenResponseEmpty_WhenGetContactsVO_ThenAssertEmpty() {
        whenever(runBlocking { contactApi.contactsAsync() }) doReturn emptyList()
        val result = runBlocking { contactsRepository.getContacts() }
        assertEquals(emptyList<ContactVO>(), result)
    }
}