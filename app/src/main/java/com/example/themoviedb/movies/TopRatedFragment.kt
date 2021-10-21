package com.example.themoviedb.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.themoviedb.databinding.TopRatedFragmentBinding
import com.example.themoviedb.movies.adapters.MovieAdapter

class TopRatedFragment : Fragment() {

    private lateinit var binding: TopRatedFragmentBinding
    private val viewModel: TopRatedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TopRatedFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.moviesGrid.adapter = MovieAdapter()
        return binding.root
    }

}