package com.example.themoviedb.movies.api

import retrofit2.http.GET


public interface ApiService {
@GET
Call<MovieResponse> getMovies();
}