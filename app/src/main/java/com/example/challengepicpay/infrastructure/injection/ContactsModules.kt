package com.example.challengepicpay.infrastructure.injection

import com.example.challengepicpay.BuildConfig
import com.example.challengepicpay.infrastructure.network.createApi
import com.example.challengepicpay.infrastructure.network.provideOkHttpClient
import com.example.challengepicpay.infrastructure.network.provideRetrofit
import com.example.challengepicpay.presentation.feature.contacts.ContactsViewModel
import com.example.challengepicpay.domain.usecase.GetContactsUseCase
import com.example.challengepicpay.data.repository.remote.api.ContactsApi
import com.example.challengepicpay.data.repository.ContactsRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

private const val URL = BuildConfig.BASE_URL

private val uiModule = module {
    viewModel { ContactsViewModel(get()) }
}

private val contactsModule = module {
    single<GetContactsUseCase> {
        ContactsRepository(
            get()
        )
    }
}

private val remoteModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(URL, get()) }
    single { createApi<ContactsApi>(get()) }
}

internal fun initContactsModule() = loadKoinModules(listOf(uiModule, contactsModule, remoteModule))