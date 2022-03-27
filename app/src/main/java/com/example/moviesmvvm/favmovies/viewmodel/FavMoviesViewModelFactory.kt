package com.example.moviesmvvm.favmovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesmvvm.allmovies.viewmodel.AllMoviesViewModel
import com.example.moviesmvvm.model.RepositoryInterface

class FavMoviesViewModelFactory(private val _repo: RepositoryInterface): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(FavMoviesViewModel::class.java)){
            FavMoviesViewModel(_repo) as T
        } else{
            throw IllegalArgumentException("not found view model class")
        }
    }
}