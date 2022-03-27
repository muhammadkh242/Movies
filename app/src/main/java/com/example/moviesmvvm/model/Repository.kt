package com.example.moviesmvvm.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.moviesmvvm.db.LocalSource
import com.example.moviesmvvm.network.NetworkDelegate
import com.example.moviesmvvm.network.RemoteSource

class Repository(context: Context, remoteSource: RemoteSource, localSource: LocalSource) : RepositoryInterface {
    var remoteSource = remoteSource
    var localSource = localSource
    companion object{
        private var repo: Repository? = null

        fun getInstance(context: Context, remoteSource: RemoteSource, localSource: LocalSource): Repository{
            if(repo == null){
                repo = Repository(context, remoteSource, localSource)
            }
            return repo!!
        }

    }
    override fun getAllMovies(networkDelegate: NetworkDelegate?) {
        remoteSource.enqueueCall(networkDelegate!!)
    }

    override fun getStoredMovies(): LiveData<List<Movie?>?>? {
        return localSource.getStoredMovies()
    }

    override fun insertMovie(movie: Movie) {
        localSource.insertMovie(movie)
    }

    override fun deleteMovie(movie: Movie) {
        localSource.deleteMovie(movie)
    }
}