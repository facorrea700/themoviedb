package com.example.themoviedb.movies

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.*
import com.example.themoviedb.movies.network.Movie
import com.example.themoviedb.movies.network.Movies
import com.example.themoviedb.movies.network.MoviesApi
import kotlinx.coroutines.launch


class PopularMoviesViewModel : ViewModel() {

    private val _movies = MutableLiveData<Movies?>()
    val movies: LiveData<Movies?> = _movies


    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            try {
                _movies.value = MoviesApi.retrofitService.getPopular()
                Log.d("nasheiLog", _movies.value?.movies.toString())
            } catch (e: Exception) {
                _movies.value = null
            }
        }
    }
}



