package br.com.hellopetdesign.data.room.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface GenericDao<T> {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(obj: T): Long

    @Insert
    suspend fun insert(vararg obj: T): Array<Long>

    @Insert
    suspend fun insert(obj: List<T>): Array<Long>

    @Delete
    suspend fun delete(obj: T)

    @Update
    suspend fun update(obj: T)
}