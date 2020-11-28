package com.example.apptryout.presenter

import com.example.apptryout.App
import com.example.apptryout.RegisterContract
import com.example.apptryout.UserSession
import com.example.apptryout.model.BodyRegistration
import com.example.apptryout.model.ResponseModel
import com.example.apptryout.repository.UserRemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter (private val view: RegisterContract.View, private val repository: UserRemoteRepository): RegisterContract.Presenter{
    private val prefs: UserSession by lazy {
        UserSession(App.instance)
    }

    override fun userRegister(registerBody: BodyRegistration) {

        repository.userRegister(registerBody).enqueue(object : Callback<ResponseModel<String>> {
            override fun onResponse(call: Call<ResponseModel<String>>, response: Response<ResponseModel<String>>) {
                if (response.isSuccessful) {
                    if (response.body()!!.status) {
//                        val user = response.body()!!.data

                        prefs.email = registerBody.email
                        prefs.name = registerBody.name
                        prefs.password = registerBody.password
                        prefs.token = "Bearer ${response.body()!!.data}"
                        prefs.loggedIn = true


                        view.onSuccessRegister(response.body()!!.message)
                    }

                } else {
                    TODO("Not yet implemented")
                }

            }

            override fun onFailure(call: Call<ResponseModel<String>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun getAllContact() {
        TODO("Not yet implemented")
    }

}