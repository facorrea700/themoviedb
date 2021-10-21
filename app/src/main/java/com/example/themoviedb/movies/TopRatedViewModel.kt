package com.example.themoviedb.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.movies.network.Movies
import com.example.themoviedb.movies.network.MoviesApi
import kotlinx.coroutines.launch

class TopRatedViewModel : ViewModel() {
    private val _movies = MutableLiveData<Movies?>()
    val movies: LiveData<Movies?> = _movies


    init {
        getTopRated()
    }

    private fun getTopRated() {
        viewModelScope.launch {
            try {
                _movies.value = MoviesApi.retrofitService.getTopRated()
            } catch (e: Exception) {
                _movies.value = null
            }
        }
    }
}