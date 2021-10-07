package com.example.themoviedb.user.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.themoviedb.R
import com.example.themoviedb.databinding.FragmentLoginBinding
import com.example.themoviedb.user.User
import com.example.themoviedb.user.data.UserApplication

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController

    private lateinit var user: User

    private val viewModel: LoginViewModel by activityViewModels {
        LoginViewModelFactory(
            (activity?.application as UserApplication).database.userDao()
        )
    }

    private fun recoverUser(mail: String, password: String): LiveData<User> {
        return viewModel.recoverUser(mail, password)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.textViewNotRegister.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.buttonLogin.setOnClickListener {
            var mail: String = binding.inputMail.text.toString()
            var passowrd: String = binding.inputPassword.text.toString()

            recoverUser(mail,passowrd).observe(this.viewLifecycleOwner) {
                Log.d("test", it.firstName.toString())
                var name: String = it.firstName.toString()
                val bundle = bundleOf("name" to name)
                navController.navigate(R.id.action_loginFragment_to_home, bundle)
            }
        }
    }
}
