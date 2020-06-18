package br.com.hellopetdesign.data.room

import android.content.Context
import androidx.room.Room

object Database {
    private lateinit var localDatabase: AppDatabase
    val instance = localDatabase

    fun init(context: Context) {
        localDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
    }

}