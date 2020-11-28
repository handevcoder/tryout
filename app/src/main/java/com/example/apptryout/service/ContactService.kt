package com.example.apptryout.service

import com.example.apptryout.model.ContactModel
import com.example.apptryout.model.ResponseModel
import com.example.apptryout.response.ContactResponse
import retrofit2.Call
import retrofit2.http.*

interface ContactService {
    @GET("api/v1/contacts")
    fun getAllContact(
        @Header("Authorization")
        token: String
    ): Call<ResponseModel<List<ContactModel>>>
    @POST("api/v1/contacts")
    fun createProduct(
        product: ContactResponse
    ): Call<ResponseModel<List<ContactModel>>>

    @PUT("api/v1/contacts")
    fun updateProductById(
        @Path("id") id: Int, product: ContactResponse
    ): Call<ResponseModel<List<ContactModel>>>

    @DELETE("api/v1/contacts")
    fun deleteProductById(
        @Path("id") id: Int
    ): Call<ResponseModel<List<ContactModel>>>
}
