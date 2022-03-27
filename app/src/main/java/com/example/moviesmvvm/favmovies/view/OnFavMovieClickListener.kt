package com.example.moviesmvvm.favmovies.view

import com.example.moviesmvvm.model.Movie

interface OnFavMovieClickListener {
    fun onClick(movie: Movie)
}