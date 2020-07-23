package com.example.challengepicpay.data.repository.remote.mapper

import com.example.challengepicpay.domain.model.ContactVO
import com.example.challengepicpay.data.repository.remote.response.ContactsResponse

fun List<ContactsResponse>.toValueObject(): List<ContactVO> {
    return this
        .asSequence()
        .map { ContactVO(it.img, it.name, it.id, it.username) }
        .toList()
}