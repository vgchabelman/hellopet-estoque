package br.com.hellopetdesign.local.daos

import androidx.room.Dao
import androidx.room.Query
import br.com.hellopetdesign.local.entities.ProductMaterialEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductMaterialDao: GenericDao<ProductMaterialEntity> {
    @Query("SELECT * FROM PRODUCT_MATERIAL WHERE FK_PRODUCT = :productId")
    fun getMaterialsByProduct(productId: Long): Flow<List<ProductMaterialEntity>>
}