package com.example.apptryout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.apptryout.contract.ContactContract
import com.example.apptryout.databinding.FragmentContactBinding
import com.example.apptryout.model.ContactModel
import com.example.apptryout.presenter.ContactPresenter
import com.example.apptryout.repository.ContactRemoteRepository
import com.example.apptryout.service.ContactService

class ContactFragment : Fragment(), ContactContract.View, ContactAdapter.ContactListerner {

    lateinit var binding : FragmentContactBinding
    private val adapter by lazy { ContactAdapter(requireContext(), this) }

    private val service: ContactService by lazy { Api.contactService }
    private val repositoryContact: ContactRemoteRepository by lazy { ContactRemoteRepository(service) }
    private val presenter: ContactPresenter by lazy { ContactPresenter(this, repositoryContact) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactBinding.inflate(inflater, container, false)

        setView()
        return binding.root
    }

    private fun setView() {

    }

    override fun onResume() {
        super.onResume()
        presenter.getAllContact()
    }

    override fun onSuccessGetContact(list: List<ContactModel>) {
        TODO("Not yet implemented")
    }

    override fun onFailed(message: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccessDeleteContact(message: String, id: Int) {
        TODO("Not yet implemented")
    }

    override fun loading() {
        TODO("Not yet implemented")
    }

    override fun onClick(contactModel: ContactModel) {
        TODO("Not yet implemented")
    }

    override fun onDelete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun onChange(contactModel: ContactModel) {
        TODO("Not yet implemented")
    }


}