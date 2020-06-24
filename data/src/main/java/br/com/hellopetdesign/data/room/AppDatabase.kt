package br.com.hellopetdesign.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.hellopetdesign.data.room.daos.*
import br.com.hellopetdesign.data.room.entities.*

@Database(
    entities = [
        ProductEntity::class,
        MaterialEntity::class,
        SupplierEntity::class,
        ProductMaterialEntity::class,
        LastUpdateEntity::class
    ],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun materialDao(): MaterialDao
    abstract fun supplierDao(): SupplierDao
    abstract fun productMaterialDao(): ProductMaterialDao
    abstract fun lastUpdateDao(): LastUpdateDao
}