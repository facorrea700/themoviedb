package com.example.inventory

import android.app.Application
import com.example.themoviedb.user.data.UserRoomDatabase

class UserApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database: UserRoomDatabase by lazy { UserRoomDatabase.getDatabase(this) }
}