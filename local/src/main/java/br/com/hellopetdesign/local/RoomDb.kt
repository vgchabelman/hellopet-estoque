package br.com.hellopetdesign.local

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class RoomDb(context: Context) {
    var localDatabase: AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    )
        .addMigrations(migration1to2())
        .build()

    private fun migration1to2(): Migration {
        return object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE 'LAST_UPDATE' (" +
                        "'row_id' INTEGER PRIMARY KEY NOT NULL," +
                        "'material' INTEGER NOT NULL, " +
                        "'name' INTEGER NOT NULL, " +
                        "'suppliers' INTEGER NOT NULL)")
            }
        }
    }
}