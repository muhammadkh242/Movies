package com.example.moviesmvvm.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")

data class Movie(
    @PrimaryKey
    @ColumnInfo(name = "title")
    @NonNull
    val title: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "rating")
    val rating: Float,

    @ColumnInfo(name = "releaseYear")
    val releaseYear: Int) {
}