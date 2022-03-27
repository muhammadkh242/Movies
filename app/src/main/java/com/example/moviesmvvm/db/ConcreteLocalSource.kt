package com.example.moviesmvvm.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.moviesmvvm.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConcreteLocalSource(context: Context): LocalSource {
    private var dataBase= AppDataBase.getInstance(context.applicationContext)
    private var movieDAO: MovieDAO? = dataBase.movieDAO()
    private var storedMovies: LiveData<List<Movie?>?>? = movieDAO?.getStoredMovies()

    companion object{
        private var localSource: ConcreteLocalSource? = null
        fun getInstance(context: Context): ConcreteLocalSource{
            if(localSource == null){
                localSource = ConcreteLocalSource(context)
            }
            return localSource!!
        }

    }

    override fun getStoredMovies(): LiveData<List<Movie?>?>? {
        return storedMovies
    }

    override fun insertMovie(movie: Movie) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO?.insertMovie(movie)
        }
    }

    override fun deleteMovie(movie: Movie) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO?.deleteMovie(movie)
        }
    }
}