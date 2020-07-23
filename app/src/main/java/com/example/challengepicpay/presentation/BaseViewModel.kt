package com.example.challengepicpay.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel(), CoroutineScope {
    private val viewModelJob = SupervisorJob()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + viewModelJob

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancelChildren()
    }
}