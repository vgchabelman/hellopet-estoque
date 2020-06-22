package br.com.hellopetdesign.data.room

import android.content.Context
import androidx.room.Room

class Database(context: Context) {
    var localDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
}