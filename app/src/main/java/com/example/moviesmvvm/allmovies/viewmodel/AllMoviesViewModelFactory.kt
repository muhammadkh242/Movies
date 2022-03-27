package com.example.moviesmvvm.allmovies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesmvvm.model.RepositoryInterface

class AllMoviesViewModelFactory(private val _repo: RepositoryInterface): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(AllMoviesViewModel::class.java)){
            AllMoviesViewModel(_repo) as T
        } else{
            throw IllegalArgumentException("not found view model class")
        }
    }
}