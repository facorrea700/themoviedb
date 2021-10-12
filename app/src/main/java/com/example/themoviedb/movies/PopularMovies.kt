package com.example.themoviedb.movies


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.themoviedb.databinding.FragmentPopularMoviesBinding

class PopularMovies : Fragment() {
    val baseURL: String = "https://api.themoviedb.org/3/"
    val apiKey: String = "f5e62dd71534cda3bc0836dded02e7ad"

    private lateinit var binding: FragmentPopularMoviesBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }


}