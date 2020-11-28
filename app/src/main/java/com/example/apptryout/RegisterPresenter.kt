package com.example.apptryout

import com.example.apptryout.repository.ContactRemoteRepository
import com.example.apptryout.repository.UserRemoteRepository

class RegisterPresenter(
    private val view: RegisterContract.View,
    private val repositoryUser: UserRemoteRepository,
    private val repository: ContactRemoteRepository
) {
}