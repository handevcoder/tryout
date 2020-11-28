package com.example.apptryout

import com.example.apptryout.model.ContactModel
import com.example.apptryout.model.LoginBody
import com.example.apptryout.model.ResponseModel
import com.example.apptryout.model.UserModel
import com.example.apptryout.repository.ContactRemoteRepository
import com.example.apptryout.repository.UserRemoteRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors

class LoginPresenter(
    private val view: LoginContract.View,
    private val repositoryUser: UserRemoteRepository,
    private val repository: ContactRemoteRepository
) : LoginContract.Presenter {
    private val executorService by lazy { Executors.newFixedThreadPool(4) }

    override fun userLogin(loginBody: LoginBody) {
        repositoryUser.userLogin(loginBody).enqueue(object : Callback<ResponseModel<UserModel>> {
            override fun onResponse(
                call: Call<ResponseModel<UserModel>>,
                response: Response<ResponseModel<UserModel>>
            ) {
                if (response.isSuccessful) {
                    view.onSuccessLogin(response.body()!!.data.token)
                }
            }

            override fun onFailure(call: Call<ResponseModel<UserModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    override fun getAllContact() {
        repository.getAllContact().enqueue(object : Callback<ResponseModel<List<ContactModel>>>{
            override fun onResponse(
                call: Call<ResponseModel<List<ContactModel>>>,
                response: Response<ResponseModel<List<ContactModel>>>
            ) {
                view.onSuccessGetContact(response.body()!!.data)
            }

            override fun onFailure(call: Call<ResponseModel<List<ContactModel>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}