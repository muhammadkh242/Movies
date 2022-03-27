package com.example.moviesmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.moviesmvvm.allmovies.view.AllMoviesActivity
import com.example.moviesmvvm.favmovies.view.FavMoviesActivity

class MainActivity : AppCompatActivity() {

    private lateinit var allBtn: Button
    private lateinit var favBtn: Button
    private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allBtn = findViewById(R.id.allBtn)
        favBtn = findViewById(R.id.favBtn)
        exitBtn = findViewById(R.id.exitBtn)

        allBtn.setOnClickListener {
            var intent: Intent = Intent(applicationContext, AllMoviesActivity::class.java)
            startActivity(intent)

        }

        favBtn.setOnClickListener {
            var intent: Intent = Intent(applicationContext, FavMoviesActivity::class.java)
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finish()

        }
    }
}