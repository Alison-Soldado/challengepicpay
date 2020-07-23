package com.example.challengepicpay.presentation.feature.contacts

import android.os.Bundle
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengepicpay.R
import com.example.challengepicpay.presentation.extension.bindView
import com.example.challengepicpay.presentation.extension.toast
import com.example.challengepicpay.presentation.extension.visibilityLoading
import com.example.challengepicpay.infrastructure.injection.initContactsModule
import com.example.challengepicpay.presentation.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactsActivity : BaseActivity() {

    private val contactAdapter = ContactsAdapter()
    private val contactsViewModel: ContactsViewModel by viewModel()
    private val recyclerViewUsers: RecyclerView by bindView(R.id.activity_main_recycler_view_users)
    private val progressLoading: ProgressBar by bindView(R.id.activity_main_progress_loading)

    override fun initInjection() {
        initContactsModule()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        initViews()
        getContacts()
        initObservableState()
    }

    private fun initViews() {
        with(recyclerViewUsers) {
            layoutManager = LinearLayoutManager(context)
            adapter = contactAdapter
        }
    }

    private fun getContacts() {
        contactsViewModel.contacts()
    }

    private fun initObservableState() {
        contactsViewModel.viewState.observe(this, Observer { viewState ->
            when(viewState) {
                is ContactsViewState.Success -> contactAdapter.setData(viewState.contacts)
                is ContactsViewState.Error -> toast(R.string.error)
                is ContactsViewState.Loading -> progressLoading.visibilityLoading(viewState.isLoading)
            }
        })
    }
}