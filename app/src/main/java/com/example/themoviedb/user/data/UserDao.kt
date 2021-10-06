package com.example.themoviedb.user.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.themoviedb.user.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * from User WHERE mail = :mail AND password = :password")
    fun getUser(mail: String, password: String): Flow<User>

    @Insert
    fun insert(vararg users: User)
}
