package com.example.apptryout.contract

import com.example.apptryout.model.ContactModel

interface ContactContract {
    interface View{
        fun onSuccessGetContact(list: List<ContactModel>)
        fun onFailed(message: String)
        fun onSuccessDeleteContact(message: String, id: Int)

        fun loading()

    }

    interface Presenter{
        fun getAllContact()
        fun deleteContact(contactModel: ContactModel, position: Int)
    }
}