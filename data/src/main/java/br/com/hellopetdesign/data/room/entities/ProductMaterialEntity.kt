package br.com.hellopetdesign.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "PRODUCT_MATERIAL",
    primaryKeys = ["FK_PRODUCT", "FK_MATERIAL"]
)
data class ProductMaterialEntity(
    @ColumnInfo(name = "FK_PRODUCT") val productId: Long,
    @ColumnInfo(name = "FK_MATERIAL") val materialId: Int,
    val quantity: Double
)