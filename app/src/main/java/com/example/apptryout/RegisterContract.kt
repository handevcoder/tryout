package com.example.apptryout

import com.example.apptryout.model.BodyRegistration
import com.example.apptryout.model.ContactModel

interface RegisterContract {
    interface View{
        fun onSuccessRegister(token: String)
        fun onSuccessGetContact(list: List<ContactModel>)
    }

    interface Presenter{
        fun userRegister(bodyRegistration: BodyRegistration)
        fun getAllContact()
    }
}