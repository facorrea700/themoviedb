package com.example.themoviedb.movies.network
import com.squareup.moshi.Json

data class Movie(
    val id: String,
    // used to map img_src from the JSON to imgSrcUrl in our class
    @Json(name = "title") val title: String
)