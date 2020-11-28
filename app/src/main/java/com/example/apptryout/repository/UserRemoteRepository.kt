package com.example.apptryout.repository

import com.example.apptryout.model.LoginBody
import com.example.apptryout.model.ResponseModel
import com.example.apptryout.model.UserModel
import com.example.apptryout.service.UserService
import retrofit2.Call

class UserRemoteRepository(private val service: UserService) {
    fun userLogin(loginBody: LoginBody): Call<ResponseModel<UserModel>> {
        return service.userLogin(loginBody)
    }

    fun userRegister(loginBody: LoginBody): Call<ResponseModel<UserModel>> {
        return service.userLogin(loginBody)
    }

}