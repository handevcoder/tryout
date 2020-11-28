package com.example.apptryout

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptryout.databinding.ItemContactBinding
import com.example.apptryout.model.UserModel

class ContactAdapter(
    private val context: Context,
    private val listener: ContactListener
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    var list = mutableListOf<UserModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    interface ContactListener {
        fun onClick(userModel: UserModel)
        fun onDelete(id: Long)
        fun onChange(userModel: UserModel)
    }

    fun addUser(userModel: UserModel) {
        list.add(0, userModel)
        notifyItemInserted(0)
    }

    fun deleteUser(id: Int) {
        val index = list.indexOfFirst { it.id == id }
        if (index != -1) {
            list.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    fun updateTodo(userModel: UserModel) {
        val index = list.indexOfFirst { it.id == userModel.id }
        if (index != -1) {
            list[index] = userModel
            notifyItemChanged(index)
        }
    }


    inner class ViewHolder(
        private val binding: ItemContactBinding,
        private val listener: ContactListener
    ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemContactBinding.inflate(LayoutInflater.from(context), parent, false),
            listener
        )
    }


    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(list[position])
    }


}