package com.example.themoviedb.user.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.themoviedb.user.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * from user WHERE first_name = :username AND password = :password")
    fun getUser(username: String, password: String): Flow<User>

    @Insert
    fun insert(vararg users: User)
}
