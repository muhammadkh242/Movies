package com.example.moviesmvvm.network

import com.example.moviesmvvm.model.Movie

interface NetworkDelegate {
    fun onSuccessfulResult(movies: List<Movie>)

}