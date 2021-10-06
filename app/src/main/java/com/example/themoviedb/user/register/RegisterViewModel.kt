package com.example.themoviedb.user.register

import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.user.User
import com.example.themoviedb.user.data.UserDao
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao) : ViewModel() {
    fun addNewItem(userName: String, lastName: String, mail: String, password: String) {
        val newUser = getNewUserEntry(userName, lastName, mail, password)
        insertUser(newUser)
    }

    private fun insertUser(user: User) {
        viewModelScope.launch {
            AsyncTask.execute {
                userDao.insert(user)
            }
        }
    }

    fun isEntryValid(userName: String, lastName: String, password: String, mail: String): Boolean {
        if (userName.isBlank() || lastName.isBlank() || password.isBlank() || mail.isBlank()) {
            return false
        }
        return true
    }

    private fun getNewUserEntry(
        userName: String,
        lastName: String,
        mail: String,
        password: String
    ): User {
        return User(
            firstName = userName,
            lastName = lastName,
            password = password,
            mail = mail,
        )
    }
}

class UserViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
