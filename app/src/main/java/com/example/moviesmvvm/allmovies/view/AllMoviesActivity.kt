package com.example.moviesmvvm.allmovies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesmvvm.R
import com.example.moviesmvvm.allmovies.viewmodel.AllMoviesViewModel
import com.example.moviesmvvm.allmovies.viewmodel.AllMoviesViewModelFactory
import com.example.moviesmvvm.db.ConcreteLocalSource
import com.example.moviesmvvm.model.Movie
import com.example.moviesmvvm.model.Repository
import com.example.moviesmvvm.network.MovieClient

class AllMoviesActivity : AppCompatActivity(), OnMovieClickListener {

    lateinit var factory: AllMoviesViewModelFactory
    lateinit var viewModel: AllMoviesViewModel
    lateinit var allRecycler: RecyclerView
    lateinit var allMoviesAdapter: AllMoviesAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_movies)
        initUI()
        setUpRecyclerView()
        progressBar.visibility = View.VISIBLE
        factory = AllMoviesViewModelFactory(Repository.getInstance(this,MovieClient.getInstance(), ConcreteLocalSource.getInstance(this)))

        viewModel = ViewModelProvider(this, factory).get(AllMoviesViewModel::class.java)

        viewModel.movies.observe(this, {
            allMoviesAdapter.movies = it
            allMoviesAdapter.notifyDataSetChanged()
            progressBar.visibility = View.INVISIBLE

        })
    }

    override fun onClick(movie: Movie) {
        viewModel.addToFav(movie)

    }
    private fun setUpRecyclerView(){
        layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        allMoviesAdapter = AllMoviesAdapter(this, this)
        allRecycler.adapter = allMoviesAdapter
        allRecycler.layoutManager = layoutManager
    }

    private fun initUI(){
        allRecycler = findViewById(R.id.allRecyclerview)
        progressBar = findViewById(R.id.progress)
    }


}