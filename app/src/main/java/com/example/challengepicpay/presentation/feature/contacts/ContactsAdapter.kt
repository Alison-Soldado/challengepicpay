package com.example.challengepicpay.presentation.feature.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.challengepicpay.R
import com.example.challengepicpay.domain.model.ContactVO

class ContactsAdapter: RecyclerView.Adapter<ContactsItemViewHolder>() {

    private var contacts = emptyList<ContactVO>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                ContactsDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    fun setData(contacts: List<ContactVO>) {
        this.contacts = contacts
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactsItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsItemViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount() = contacts.size

}