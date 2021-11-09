package com.example.themoviedb.user.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.themoviedb.R
import com.example.themoviedb.databinding.FragmentLoginBinding
import com.example.themoviedb.user.User
import com.example.themoviedb.user.data.UserApplication

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController

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
        (activity as AppCompatActivity).supportActionBar?.title = "Login"
        navController = Navigation.findNavController(view)
        binding.textViewNotRegister.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.buttonLogin.setOnClickListener {
            val mail: String = binding.inputMail.text.toString()
            val password: String = binding.inputPassword.text.toString()
            recoverUser(mail, password).observe(this.viewLifecycleOwner) {
                try {
                    val name: String = it.firstName.toString()
                    val bundle = bundleOf("name" to name)
                    loggedUser(it)
                    navController.navigate(R.id.action_loginFragment_to_homeFragment, bundle)
                }catch (ex: Exception){
                    Toast.makeText(context, "Wrong user or password", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun loggedUser(user: User) {
        val name: String = user.firstName + " " + user.lastName
        val mail: String = user.mail.toString()
        Log.d("user passed", name)
        User.name = name
        User.email = mail
    }
}
