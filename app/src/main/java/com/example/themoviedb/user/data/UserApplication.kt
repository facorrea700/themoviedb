package com.example.themoviedb.user.data

import android.app.Application
import com.example.themoviedb.user.data.UserDatabase

class UserApplication : Application(){
    val database: UserDatabase by lazy { UserDatabase.getDatabase(this) }
}