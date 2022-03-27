package com.example.moviesmvvm.db

import androidx.lifecycle.LiveData
import com.example.moviesmvvm.model.Movie

interface LocalSource {

    fun getStoredMovies(): LiveData<List<Movie?>?>?

    fun insertMovie(movie: Movie)

    fun deleteMovie(movie: Movie)


}