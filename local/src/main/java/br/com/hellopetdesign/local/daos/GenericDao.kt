package br.com.hellopetdesign.local.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface GenericDao<T> {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(obj: T): Long

    @Insert
    suspend fun insert(vararg obj: T): Array<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: List<T>): Array<Long>

    @Delete
    suspend fun delete(obj: T)

    @Update
    suspend fun update(obj: T)
}