package com.example.moviesmvvm.allmovies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesmvvm.model.Movie
import com.example.moviesmvvm.model.RepositoryInterface
import com.example.moviesmvvm.network.NetworkDelegate

class AllMoviesViewModel(private val _repo: RepositoryInterface): ViewModel(), NetworkDelegate {


    init{
        _repo.getAllMovies(this)
    }
    private var _movies: MutableLiveData<List<Movie>> = MutableLiveData()
    var movies: LiveData<List<Movie>> = _movies

    override fun onSuccessfulResult(movies: List<Movie>) {
        _movies.postValue(movies)
    }

    fun addToFav(movie: Movie){
        _repo.insertMovie(movie)
    }


}