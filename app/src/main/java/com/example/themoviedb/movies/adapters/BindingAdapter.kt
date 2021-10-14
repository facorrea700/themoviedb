package com.example.themoviedb.movies.adapters

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import coil.load
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.movies.network.Movie

private const val BASE_URL_IMG = "https://image.tmdb.org/t/p/w500"

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    val completeUrl = "${BASE_URL_IMG + imgUrl}"
    Log.d("nasheee", completeUrl)
    imgUrl?.let {
        val imgUri = completeUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<Movie>?
) {
    val adapter = recyclerView.adapter as MovieAdapter
    adapter.submitList(data)

}