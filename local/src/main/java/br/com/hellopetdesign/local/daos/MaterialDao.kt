package br.com.hellopetdesign.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import br.com.hellopetdesign.local.entities.MaterialEntity
import br.com.hellopetdesign.local.entities.MaterialWithSupplier
import kotlinx.coroutines.flow.Flow

@Dao
interface MaterialDao : GenericDao<MaterialEntity> {
    @Query("SELECT * FROM MATERIAL")
    fun getAllMaterials(): Flow<List<MaterialEntity>>

    @Transaction
    @Query("SELECT * FROM MATERIAL WHERE materialId = :materialId")
    fun getMaterialWithSupplier(materialId: Int): Flow<MaterialWithSupplier>
}