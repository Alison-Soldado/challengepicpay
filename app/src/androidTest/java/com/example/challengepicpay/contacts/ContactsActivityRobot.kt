package com.example.challengepicpay.contacts

import android.app.Activity
import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.example.challengepicpay.BaseRobotTest
import com.example.challengepicpay.presentation.feature.contacts.ContactsActivity
import okhttp3.mockwebserver.MockWebServer

fun contacts(func: ContactsActivityRobot.() -> Unit) = ContactsActivityRobot().apply { func() }

class ContactsActivityRobot : BaseRobotTest() {

    fun startActivity(activityRule: ActivityTestRule<ContactsActivity>) {
        activityRule.launchActivity(Intent())
    }

    fun setupServerSuccess(server: MockWebServer) {
        setupServer(server, 200, "contacts_success.json")
    }

    fun setupServerError(server: MockWebServer) {
        setupServer(server, 400, "contacts_error.json")
    }

    fun checkItemRecyclerView() {
        checkTextItemRecyclerView("Eduardo Santos")
    }

    @Suppress("UNCHECKED_CAST")
    fun checkToastError(activityRule: ActivityTestRule<ContactsActivity>) {
        checkToast("Ocorreu um erro. Tente novamente.", activityRule as ActivityTestRule<Activity>)
    }
}