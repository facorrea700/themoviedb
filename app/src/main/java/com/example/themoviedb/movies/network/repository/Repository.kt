package com.example.themoviedb.movies.network.repository

import com.example.themoviedb.movies.network.Movie
import com.example.themoviedb.movies.network.RetrofitInstance

class Repository {
    suspend fun getMovies(): Movie{
        return RetrofitInstance.api.getMovies()
    }
}