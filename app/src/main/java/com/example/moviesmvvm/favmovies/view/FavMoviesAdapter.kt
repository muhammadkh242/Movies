package com.example.moviesmvvm.favmovies.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesmvvm.R
import com.example.moviesmvvm.allmovies.view.OnMovieClickListener
import com.example.moviesmvvm.model.Movie

class FavMoviesAdapter(context: Context, onFavClickListener: OnFavMovieClickListener)
    : RecyclerView.Adapter<FavMoviesAdapter.ViewHolder> (){

    var context: Context = context
    var movies: List<Movie> = listOf()
    var onFavClickListener: OnFavMovieClickListener = onFavClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.favmovie_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = movies[position].title
        holder.year.text = Integer.toString(movies[position].releaseYear)
        holder.rating.rating = movies[position].rating
        Glide.with(context).load(movies[position].image).into(holder.image);

        holder.delBtn.setOnClickListener {
            onFavClickListener.onClick(movies[position])
        }

    }

    override fun getItemCount(): Int {
        Log.i("TAG", "getItemCount: " + movies.size)

        return movies.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.titleTxt)
        val image: ImageView = itemView.findViewById(R.id.imageView)
        val rating: RatingBar = itemView.findViewById(R.id.ratingBar)
        val year: TextView = itemView.findViewById(R.id.yearTxt)
        val delBtn: Button = itemView.findViewById(R.id.deleteBtn)

    }
}