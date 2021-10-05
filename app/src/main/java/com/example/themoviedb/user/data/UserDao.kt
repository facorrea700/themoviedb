package com.example.themoviedb.user.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.themoviedb.user.User

@Dao
interface UserDao {

    @Query("SELECT * from user WHERE mail = :mail AND password = :password")
    fun getUser(mail: String, password: String): User

    @Insert
    fun insert(vararg users: User)
}
