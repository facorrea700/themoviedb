package com.example.themoviedb.user.login


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.themoviedb.R
import com.example.themoviedb.databinding.FragmentLoginBinding
import com.example.themoviedb.databinding.FragmentRegisterBinding
import com.example.themoviedb.user.User
import com.example.themoviedb.user.data.UserApplication
import com.example.themoviedb.user.register.RegisterFragment


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    notRegister()
    }


    private fun notRegister() {
        val button = binding.textViewNotRegister
        button.setOnClickListener(){
            Toast.makeText(context, "Cambiar a Registro", Toast.LENGTH_SHORT).show()

        }
    }
}

