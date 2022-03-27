package com.example.moviesmvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviesmvvm.model.Movie

@Dao
interface MovieDAO {
    @Query("SELECT * FROM movies")
    fun getStoredMovies(): LiveData<List<Movie?>?>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)
}