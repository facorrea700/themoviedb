package com.example.themoviedb.movies.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://api.themoviedb.org/3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MovieService {
    @GET("movies")
    suspend fun getMoviesTitles(): String
}

object MoviesAPI {
    val retrofitService: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }
}

class MovieApiService {

}