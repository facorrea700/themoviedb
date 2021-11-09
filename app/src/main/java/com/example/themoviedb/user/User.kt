package com.example.themoviedb.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "mail") val mail: String?,
    @ColumnInfo(name = "password") val password: String
) {
    companion object {
        lateinit var name: String
        lateinit var email: String
    }
}


