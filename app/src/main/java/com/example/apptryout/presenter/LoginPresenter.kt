package com.example.apptryout.presenter

import com.example.apptryout.App
import com.example.apptryout.LoginContract
import com.example.apptryout.UserSession
import com.example.apptryout.model.LoginBody
import com.example.apptryout.model.ResponseModel
import com.example.apptryout.model.UserModel
import com.example.apptryout.repository.UserRemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(private val view: LoginContract.View, private val repositoryUser: UserRemoteRepository):
    LoginContract.Presenter {

    private val prefs: UserSession by lazy {
        UserSession(App.instance)
    }

    override fun userLogin(loginBody: LoginBody) {
        repositoryUser.userLogin(loginBody).enqueue(object : Callback<ResponseModel<UserModel>> {
            override fun onResponse(
                call: Call<ResponseModel<UserModel>>,
                response: Response<ResponseModel<UserModel>>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.status) {
                        val user = response.body()!!.data

                        prefs.email = user.email
                        prefs.name = user.name
                        prefs.password = user.password
                        prefs.token = "Bearer ${user.token}"

                        prefs.loggedIn = true

                        view.onSuccessLogin( response.body()!!.message)
                    }

                } else {
                    TODO("Not yet implemented")
                }

            }

            override fun onFailure(call: Call<ResponseModel<UserModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    override fun getAllContact() {
        TODO("Not yet implemented")
    }


}