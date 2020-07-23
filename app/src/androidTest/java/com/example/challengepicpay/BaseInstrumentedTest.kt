package com.example.challengepicpay

import com.example.challengepicpay.infrastructure.injection.initContactsModule
import com.example.challengepicpay.infrastructure.network.createApi
import com.example.challengepicpay.infrastructure.network.provideOkHttpClient
import com.example.challengepicpay.infrastructure.network.provideRetrofit
import com.example.challengepicpay.presentation.feature.contacts.ContactsViewModel
import com.example.challengepicpay.domain.usecase.GetContactsUseCase
import com.example.challengepicpay.data.repository.remote.api.ContactsApi
import com.example.challengepicpay.data.repository.ContactsRepository
import io.mockk.every
import io.mockk.mockkStatic
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

open class BaseInstrumentedTest {

    lateinit var server: MockWebServer
    private lateinit var modulesTest: List<Module>

    companion object {
        private const val PACKAGE_CONTACTS_MODULES =
            "com.example.challengepicpay.infrastructure.injection.ContactsModulesKt"
    }

    @Before
    fun setup() {
        server = MockWebServer()
        server.start()

        val retrofitTest = provideRetrofit(server.url("/").toString(), provideOkHttpClient())

        val uiModuleTest = module {
            viewModel { ContactsViewModel(get()) }
        }

        val contactsModuleTest = module {
            single<GetContactsUseCase> {
                ContactsRepository(
                    createApi(retrofitTest)
                )
            }
        }

        val remoteModuleTest = module {
            single { provideOkHttpClient() }
            single { retrofitTest }
            single { createApi<ContactsApi>(retrofitTest) }
        }

        modulesTest = listOf(uiModuleTest, contactsModuleTest, remoteModuleTest)
        mockkStatic(PACKAGE_CONTACTS_MODULES)
        every { initContactsModule() } returns loadKoinModules(modulesTest)
    }


    @After
    fun tearDown() {
        server.shutdown()
        unloadKoinModules(modulesTest)
    }
}