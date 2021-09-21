package com.example.themoviedb.user.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserRoomDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null
        fun getDatabase(context: Context): UserRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    UserRoomDatabase::class.java,
                    "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                return instance

            }

        }

    }

}