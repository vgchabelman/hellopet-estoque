package br.com.hellopetdesign.data.room.daos

import androidx.room.Dao
import androidx.room.Query
import br.com.hellopetdesign.data.room.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao : GenericDao<ProductEntity> {
    @Query("SELECT * FROM Product")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM PRODUCT WHERE productId = :id")
    fun getProduct(id: Long): Flow<ProductEntity>
}