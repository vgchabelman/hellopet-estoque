package br.com.hellopetdesign.local.entities

import androidx.room.Embedded
import androidx.room.Relation

data class MaterialWithSupplier(
    @Embedded val materialEntity: MaterialEntity,
    @Relation(
        parentColumn = "supplierId",
        entityColumn = "rowid"
    )val supplierEntity: SupplierEntity
)