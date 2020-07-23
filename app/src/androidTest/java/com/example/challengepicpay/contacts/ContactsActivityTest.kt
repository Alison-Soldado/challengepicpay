package com.example.challengepicpay.contacts

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.challengepicpay.BaseInstrumentedTest
import com.example.challengepicpay.presentation.feature.contacts.ContactsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ContactsActivityTest : BaseInstrumentedTest() {

    @get:Rule
    var activityRule =
        IntentsTestRule(ContactsActivity::class.java, false, false)

    @Test
    fun givenLoadDisplay_WhenGetContactsSuccess_ThenShowListUsers() {
        contacts {
            setupServerSuccess(server)
            startActivity(activityRule)
            checkItemRecyclerView()
        }
    }

    @Test
    fun givenLoadDisplay_WhenGetContactsError_ThenShowToast() {
        contacts {
            setupServerError(server)
            startActivity(activityRule)
            checkToastError(activityRule)
        }
    }
}