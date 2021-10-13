package com.example.themoviedb.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.movies.network.Movie
import com.example.themoviedb.movies.network.repository.Repository
import kotlinx.coroutines.launch


class PopularMoviesViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Movie> = MutableLiveData()

    fun getMovies(){
        viewModelScope.launch {
        val response = repository.getMovies()
            myResponse.value= response
        }
    }
}

class PopularMoviesViewModelFactory(private val repository: Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PopularMoviesViewModel(repository) as T
    }

}


