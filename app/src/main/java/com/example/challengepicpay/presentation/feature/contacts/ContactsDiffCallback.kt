package com.example.challengepicpay.presentation.feature.contacts

import androidx.recyclerview.widget.DiffUtil
import com.example.challengepicpay.domain.model.ContactVO

class ContactsDiffCallback(
    private val oldList: List<ContactVO>,
    private val newList: List<ContactVO>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].username == newList[newItemPosition].username
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}