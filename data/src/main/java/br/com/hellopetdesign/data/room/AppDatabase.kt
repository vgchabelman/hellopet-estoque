package br.com.hellopetdesign.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.hellopetdesign.data.room.daos.MaterialDao
import br.com.hellopetdesign.data.room.daos.ProductDao
import br.com.hellopetdesign.data.room.daos.ProductMaterialDao
import br.com.hellopetdesign.data.room.daos.SupplierDao
import br.com.hellopetdesign.data.room.entities.*

@Database(
    entities = [
        ProductEntity::class,
        MaterialEntity::class,
        SupplierEntity::class,
        ProductMaterialEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun materialDao(): MaterialDao
    abstract fun supplierDao(): SupplierDao
    abstract fun productMaterialDao(): ProductMaterialDao
}