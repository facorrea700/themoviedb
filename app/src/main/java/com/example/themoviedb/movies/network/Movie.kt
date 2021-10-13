package com.example.themoviedb.movies.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movies(
    @field:Json(name = "results") val movies: List<Movie>?
)
data class Movie(
    @field:Json(name ="title") val title: String?
)