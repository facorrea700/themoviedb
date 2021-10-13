package com.example.themoviedb.movies


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.databinding.FragmentPopularMoviesBinding
import com.example.themoviedb.movies.network.repository.Repository

class PopularMovies : Fragment() {
    private lateinit var binding: FragmentPopularMoviesBinding
    private lateinit var viewModel: PopularMoviesViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository()
        val viewModelFactory = PopularMoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PopularMoviesViewModel::class.java)
        viewModel.getMovies()
        viewModel.myResponse.observe(this, Observer {
            response ->
            Log.d("Response", response.movies?.get(1).toString())
        })
    }
}