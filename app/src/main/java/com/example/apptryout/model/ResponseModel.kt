package com.example.apptryout.model

import com.google.gson.annotations.SerializedName

class ResponseModel<T>(
    @SerializedName("data")
    val data: T,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("message")
    val message: String
)