package com.example.apptryout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.apptryout.databinding.FragmentRegisterBinding
import com.example.apptryout.model.BodyRegistration
import com.example.apptryout.model.ContactModel
import com.example.apptryout.presenter.RegisterPresenter
import com.example.apptryout.repository.UserRemoteRepository
import com.example.apptryout.service.UserService

class RegisterFragment : Fragment(), RegisterContract.View{

    lateinit var binding : FragmentRegisterBinding

    private val service: UserService by lazy { Api.userService }
    private val repositoryUser: UserRemoteRepository by lazy { UserRemoteRepository(service) }
    private val presenter: RegisterPresenter by lazy { RegisterPresenter(this, repositoryUser) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        setView()

        return binding.root
    }

    private fun setView(){
        binding.apply{
            btnRegister.setOnClickListener {
                presenter.userRegister(
                    BodyRegistration(
                    tieNama.text.toString(),
                    tieEmail.text.toString(),
                    tiePassword.text.toString(),
                )
                )
            }
        }
    }

    override fun onSuccessRegister(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.homeFragment)
    }

    override fun onSuccessGetContact(list: List<ContactModel>) {
        TODO("Not yet implemented")
    }



}