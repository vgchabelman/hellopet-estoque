package br.com.hellopetdesign.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Entity(tableName = "SUPPLIER")
data class SupplierEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "rowid")
    val supplierId: Int,
    val name: String,
    val address: String
)