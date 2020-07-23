package com.example.challengepicpay

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class ContactsRunner : AndroidJUnitRunner() {

    override fun newApplication(
        classLoader: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(classLoader, PicpayApplicationTest::class.java.name, context)
    }
}