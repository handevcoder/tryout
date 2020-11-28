package com.example.apptryout.service

import com.example.apptryout.model.ContactModel
import com.example.apptryout.model.ResponseModel
import retrofit2.Call
import retrofit2.http.*

interface ContactService {
    @GET("api/v1/contacts")
    fun getAllContact(
        @Header("Authorization")
        token: String
    ): Call<ResponseModel<List<ContactModel>>>

    @DELETE("api/v1/contacts/{id}")
    fun deleteContact(
        @Header("Authorization")
        token: String,
        @Path("id")
        id: Int
    ): Call<ResponseModel<String>>
}
