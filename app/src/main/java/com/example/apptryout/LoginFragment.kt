package com.example.apptryout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.apptryout.databinding.FragmentLoginBinding
import com.example.apptryout.model.ContactModel
import com.example.apptryout.model.LoginBody
import com.example.apptryout.presenter.LoginPresenter
import com.example.apptryout.repository.UserRemoteRepository
import com.example.apptryout.service.UserService
import kotlinx.android.synthetic.main.fragment_register.*

class LoginFragment : Fragment(), LoginContract.View {
    lateinit var binding : FragmentLoginBinding

    private val service: UserService by lazy { Api.userService }
    private val repositoryUser: UserRemoteRepository by lazy { UserRemoteRepository(service) }
    private val presenter: LoginPresenter by lazy { LoginPresenter(this, repositoryUser) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        setView()
        return binding.root
    }

    private fun setView(){
        binding.apply {
            btnLogin.setOnClickListener {
                presenter.userLogin(LoginBody(tieEmail.text.toString(), tiePassword.text.toString()))
            }
            tvRegister.setOnClickListener {
                findNavController().navigate(R.id.registerFragment)
            }
        }
    }
    override fun onSuccessLogin( message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.homeFragment)

    }

    override fun onSuccessGetContact(list: List<ContactModel>) {
        TODO("Not yet implemented")
    }




}