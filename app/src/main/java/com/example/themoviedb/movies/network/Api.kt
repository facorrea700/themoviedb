package com.example.themoviedb.movies.network
import com.example.themoviedb.movies.network.Movies

import com.example.themoviedb.utils.Constants.Companion.API_KEY
import retrofit2.http.GET
interface Api {
    @GET("movie/popular?api_key=${API_KEY}")
    suspend fun getMovies(): Movies
}