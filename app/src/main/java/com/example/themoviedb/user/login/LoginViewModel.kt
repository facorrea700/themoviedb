package com.example.themoviedb.user.login

import androidx.lifecycle.*
import com.example.themoviedb.user.User
import com.example.themoviedb.user.data.UserDao

class LoginViewModel(private val userDao: UserDao) : ViewModel() {
    fun recoverUser(mail: String, password: String): LiveData<User> {
        return userDao.getUser(mail, password).asLiveData()
    }
}

class LoginViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
