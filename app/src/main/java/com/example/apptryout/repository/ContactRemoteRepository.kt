package com.example.apptryout.repository

import com.example.apptryout.model.ContactModel
import com.example.apptryout.model.ResponseModel
import com.example.apptryout.service.ContactService
import retrofit2.Call


class ContactRemoteRepository (private val service: ContactService){

    fun getAllContact(token: String ): Call<ResponseModel<List<ContactModel>>>{
        return service.getAllContact(token)
    }

    fun deleteContact(token: String, id: Int): Call<ResponseModel<String>>{
        return  service.deleteContact(token, id)
    }

}