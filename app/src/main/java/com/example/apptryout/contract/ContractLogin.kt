package com.example.apptryout.contract

import com.example.apptryout.model.LoginBody

interface ContractLogin {
    interface View{
        fun onSuccessLogin( message: String)
        fun onFailedLogin(message: String)

        fun loading()

    }

    interface Presenter{
        fun userLogin(loginBody: LoginBody)
    }
}