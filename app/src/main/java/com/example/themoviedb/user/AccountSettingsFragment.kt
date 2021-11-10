package com.example.themoviedb.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.themoviedb.R
import com.example.themoviedb.databinding.FragmentAccountSettingsBinding
import androidx.navigation.fragment.NavHostFragment.findNavController as findNavController

class AccountSettingsFragment : Fragment() {
    private lateinit var binding: FragmentAccountSettingsBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAccountSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Account Settings"
        navController = Navigation.findNavController(view)

        val username = view.findViewById<TextView>(R.id.usernameAccount)
        username.text = User.name
        val mail = view.findViewById<TextView>(R.id.userEmailAccount)
        mail.text = User.email

        binding.buttonLogout.setOnClickListener() {
            User.email = ""
            User.name = ""
//TODO : Logout
          navController.navigate(R.id.action_accountSettingsFragment2_to_loginFragment)
            Toast.makeText(context, "User logged out, login again", Toast.LENGTH_SHORT).show()
        }
    }
}
