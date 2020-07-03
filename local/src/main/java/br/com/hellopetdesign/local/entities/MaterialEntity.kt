package br.com.hellopetdesign.local.entities

import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Entity(tableName = "MATERIAL")
data class MaterialEntity(
    @PrimaryKey(autoGenerate = true)
    val materialId: Int,
    val name: String,
    val supplierId: Long
)