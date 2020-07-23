package com.example.challengepicpay.contacts

import com.example.challengepicpay.domain.model.ContactVO
import com.example.challengepicpay.data.repository.remote.response.ContactsResponse


fun contactsVOMock() : List<ContactVO> {
    return listOf(
        ContactVO(
            img = "https://randomuser.me/api/portraits/men/9.jpg",
            name = "Eduardo Santos",
            id = 1001,
            username = "@eduardo.santos"
        ),
        ContactVO(
            img = "https://randomuser.me/api/portraits/women/37.jpg",
            name = "Marina Coelho",
            id = 1002,
            username = "@marina.coelho"
        ),
        ContactVO(
            img = "https://randomuser.me/api/portraits/women/57.jpg",
            name = "Márcia da Silva",
            id = 1003,
            username = "@marcia.silva"
        )
    )
}

fun contactsResponseMock(): List<ContactsResponse> {
    return listOf(
        ContactsResponse(
            img = "https://randomuser.me/api/portraits/men/9.jpg",
            name = "Eduardo Santos",
            id = 1001,
            username = "@eduardo.santos"
        ),
        ContactsResponse(
            img = "https://randomuser.me/api/portraits/women/37.jpg",
            name = "Marina Coelho",
            id = 1002,
            username = "@marina.coelho"
        ),
        ContactsResponse(
            img = "https://randomuser.me/api/portraits/women/57.jpg",
            name = "Márcia da Silva",
            id = 1003,
            username = "@marcia.silva"
        )
    )
}