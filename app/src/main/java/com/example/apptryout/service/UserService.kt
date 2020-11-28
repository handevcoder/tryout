package com.example.apptryout.service

import com.example.apptryout.model.BodyRegistration
import com.example.apptryout.model.LoginBody
import com.example.apptryout.model.ResponseModel
import com.example.apptryout.model.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("api/v1/signin")
    fun userLogin(
        @Body
        loginBody: LoginBody
    ): Call<ResponseModel<UserModel>>

    @POST("api/v1/signup")
    fun userRegister(
        @Body
        registration: BodyRegistration
    ): Call<ResponseModel<String>>
}