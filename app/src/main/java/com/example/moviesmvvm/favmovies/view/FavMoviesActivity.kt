package com.example.moviesmvvm.favmovies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesmvvm.R
import com.example.moviesmvvm.allmovies.view.AllMoviesAdapter
import com.example.moviesmvvm.allmovies.viewmodel.AllMoviesViewModel
import com.example.moviesmvvm.allmovies.viewmodel.AllMoviesViewModelFactory
import com.example.moviesmvvm.db.ConcreteLocalSource
import com.example.moviesmvvm.favmovies.viewmodel.FavMoviesViewModel
import com.example.moviesmvvm.favmovies.viewmodel.FavMoviesViewModelFactory
import com.example.moviesmvvm.model.Movie
import com.example.moviesmvvm.model.Repository
import com.example.moviesmvvm.network.MovieClient

class FavMoviesActivity : AppCompatActivity(), OnFavMovieClickListener {

    lateinit var factory: FavMoviesViewModelFactory
    lateinit var viewModel: FavMoviesViewModel
    lateinit var favRecycler: RecyclerView
    lateinit var favMoviesAdapter: FavMoviesAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav_movies)
        initUI()
        setUpRecyclerView()

        factory = FavMoviesViewModelFactory(Repository.getInstance(this, MovieClient.getInstance(), ConcreteLocalSource.getInstance(this)))
        viewModel = ViewModelProvider(this, factory).get(FavMoviesViewModel::class.java)

        viewModel.movies?.observe(this, {
            favMoviesAdapter.movies = it as List<Movie>
            favMoviesAdapter.notifyDataSetChanged()

        })

    }

    private fun setUpRecyclerView(){
        layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        favMoviesAdapter = FavMoviesAdapter(this, this)
        favRecycler.adapter = favMoviesAdapter
        favRecycler.layoutManager = layoutManager
    }

    private fun initUI(){
        favRecycler = findViewById(R.id.favRecyclerview)


    }

    override fun onClick(movie: Movie) {
        viewModel.deleteMovie(movie)
    }
}