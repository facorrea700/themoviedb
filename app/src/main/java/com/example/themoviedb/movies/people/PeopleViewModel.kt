package com.example.themoviedb.movies.people

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.movies.network.MoviesApi
import com.example.themoviedb.movies.network.People
import kotlinx.coroutines.launch

class PeopleViewModel : ViewModel() {
    private val _people = MutableLiveData<People?>()
    val people: LiveData<People?> = _people

    init {
        getPeople()
    }

    private fun getPeople() {
        viewModelScope.launch {
            try {
                _people.value = MoviesApi.retrofitService.getPeople()
            } catch (e: Exception) {
                _people.value = null
            }
        }
    }
}