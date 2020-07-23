package com.example.challengepicpay

import androidx.test.platform.app.InstrumentationRegistry
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object JsonReader {

    fun getStringFromJsonFile(fixtureName: String): String? = try {
        val `is`: InputStream =
            InstrumentationRegistry
                .getInstrumentation()
                .targetContext
                .assets
                .open("fixture/$fixtureName")

        val size: Int = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()
        String(buffer, Charset.defaultCharset())
    } catch (ex: IOException) {
        ex.printStackTrace()
        null
    }
}