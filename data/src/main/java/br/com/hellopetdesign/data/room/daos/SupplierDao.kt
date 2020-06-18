package br.com.hellopetdesign.data.room.daos

import androidx.room.Dao
import androidx.room.Query
import br.com.hellopetdesign.data.room.entities.SupplierEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SupplierDao : GenericDao<SupplierEntity> {
    @Query("SELECT * FROM SUPPLIER")
    fun getAllSuppliers(): Flow<List<SupplierEntity>>

    @Query("SELECT * FROM SUPPLIER WHERE rowid = :id")
    fun getSupplier(id: Int): Flow<SupplierEntity>
}