package com.example.themoviedb.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.user.data.User
import com.example.themoviedb.user.data.UserDao
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao): ViewModel() {
    private fun insertUser(user: User) {
        viewModelScope.launch {
            userDao.insert(user)
        }
    }

    private fun getNewUserEntry(name: String, surname: String, mail: String, password: String): User {
        return User(
            name = name,
            surname = surname,
            mail = mail,
            password = password
        )
    }

    fun addNewUser(name: String, surname: String, mail: String, password: String) {
        val newUser = getNewUserEntry(name, surname, mail, password)
        insertUser(newUser)
    }


    fun isEntryValid(name: String, surname: String, mail: String, password: String): Boolean {
        if (name.isBlank() || surname.isBlank() || mail.isBlank() || password.isBlank()) {
            return false
        }
        return true
    }

}
class UserViewModelFactory(private val userDao: UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}