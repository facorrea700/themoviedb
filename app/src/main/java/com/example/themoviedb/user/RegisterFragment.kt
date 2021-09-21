package com.example.themoviedb.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.inventory.UserApplication
import com.example.themoviedb.R
import com.example.themoviedb.user.data.User

class RegisterFragment : Fragment() {
    private lateinit var binding: UserViewModel
    private val viewModel: UserViewModel by activityViewModels {
        UserViewModelFactory(
            (activity?.application as UserApplication).database
                .UserDao()
        )
    }
    lateinit var user: User



    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.inputRegisterName.text.toString(),
            binding.surname.text.toString(),
            binding.mail.text.toString()
            binding.password.text.toString()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

}