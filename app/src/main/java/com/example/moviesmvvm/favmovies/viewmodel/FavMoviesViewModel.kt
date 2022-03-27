package com.example.moviesmvvm.favmovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesmvvm.model.Movie
import com.example.moviesmvvm.model.RepositoryInterface

class FavMoviesViewModel(private val _repo: RepositoryInterface): ViewModel() {
    private var _movies: LiveData<List<Movie?>?>? = _repo.getStoredMovies()
    var movies: LiveData<List<Movie?>?>? = _movies

    fun deleteMovie(movie: Movie){
        _repo.deleteMovie(movie)
    }

}