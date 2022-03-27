package com.example.moviesmvvm.network

import com.example.moviesmvvm.model.Movie
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieClient: RemoteSource{
    private var baseUrl: String = "https://api.androidhive.info/"
    private lateinit var retrofit: Retrofit
    private var client: MovieClient? = null

    fun getInstance(): MovieClient{
        if(client == null){
            client = MovieClient
        }
        return client!!
    }

    override fun enqueueCall(networkDelegate: NetworkDelegate) {
        var gson: Gson = GsonBuilder().setLenient().create()
        retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            GsonConverterFactory.create(gson)).build()

        var movieService: MovieService = retrofit.create(MovieService::class.java)
        var call: Call<List<Movie?>?>? = movieService.getMovies()

        call?.enqueue(object :retrofit2.Callback<List<Movie?>?> {
            override fun onFailure(call: Call<List<Movie?>?>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Movie?>?>, response: Response<List<Movie?>?>) {
                networkDelegate.onSuccessfulResult(response.body() as List<Movie>)
            }

        })

    }

}