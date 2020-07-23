package com.example.challengepicpay

import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.example.challengepicpay.JsonReader.getStringFromJsonFile
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not

open class BaseRobotTest {

    protected fun setupServer(server: MockWebServer, code: Int, jsonMockResponse: String) {
        server.enqueue(
            MockResponse()
                .setResponseCode(code)
                .setBody(getStringFromJsonFile(jsonMockResponse))
        )
    }

    protected fun checkTextItemRecyclerView(text: String) {
        onView(withText(text))
            .check(matches(isDisplayed()))
    }

    protected fun checkToast(text: String, activityTestRule: ActivityTestRule<Activity>) {
        onView(withText(text))
            .inRoot(withDecorView(not(Matchers.`is`(activityTestRule.activity.window.decorView))))
            .check(matches(isDisplayed()))

    }
}