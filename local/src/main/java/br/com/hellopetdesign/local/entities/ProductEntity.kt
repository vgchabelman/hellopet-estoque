package br.com.hellopetdesign.local.entities

import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Entity(tableName = "PRODUCT")
data class ProductEntity(
    @PrimaryKey
    val productId: Long = 0,
    val name: String
)