package com.example.moviesmvvm.network

import com.example.moviesmvvm.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET("json/movies.json")
    fun getMovies(): Call<List<Movie?>?>?

}