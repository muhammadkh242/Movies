package com.example.moviesmvvm.allmovies.view

import com.example.moviesmvvm.model.Movie

interface OnMovieClickListener {
    fun onClick(movie: Movie)
}