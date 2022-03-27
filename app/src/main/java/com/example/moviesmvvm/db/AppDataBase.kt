package com.example.moviesmvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesmvvm.model.Movie

@Database(entities = [Movie::class], version = 1)

abstract class AppDataBase: RoomDatabase() {
    abstract fun movieDAO(): MovieDAO?

    companion object{
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase{
            if(instance == null){
                instance = Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, "movies")
                    .build()
            }
            return instance!!
        }
    }
}