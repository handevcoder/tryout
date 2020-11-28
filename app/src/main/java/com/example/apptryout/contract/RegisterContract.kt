package com.example.apptryout.contract

import com.example.apptryout.model.BodyRegistration

interface RegisterContract {
    interface View{
        fun onSuccessRegister( message: String)
        fun onFailedRegister(message: String)

        fun loading()

    }

    interface Presenter{
        fun userRegister(registerBody: BodyRegistration)
    }
}