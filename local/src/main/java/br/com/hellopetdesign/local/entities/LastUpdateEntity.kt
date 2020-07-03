package br.com.hellopetdesign.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LAST_UPDATE")
data class LastUpdateEntity(
    @PrimaryKey val row_id: Int = 1,
    val material: Int = 1,
    @ColumnInfo(name = "PRODUCTS")var products: Int = 1,
    val suppliers: Int = 1
)