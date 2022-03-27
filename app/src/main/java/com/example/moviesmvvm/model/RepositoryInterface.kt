package com.example.moviesmvvm.model

import androidx.lifecycle.LiveData
import com.example.moviesmvvm.network.NetworkDelegate

interface RepositoryInterface {
    //from network
    fun getAllMovies(networkDelegate: NetworkDelegate?)

    fun getStoredMovies(): LiveData<List<Movie?>?>?

    fun insertMovie(movie: Movie)
    fun deleteMovie(movie: Movie)

}