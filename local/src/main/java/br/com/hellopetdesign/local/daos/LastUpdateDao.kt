package br.com.hellopetdesign.local.daos

import androidx.room.Dao
import androidx.room.Query
import br.com.hellopetdesign.local.entities.LastUpdateEntity

@Dao
interface LastUpdateDao: GenericDao<LastUpdateEntity> {

    @Query("SELECT * FROM LAST_UPDATE LIMIT 1")
    suspend fun getLastUpdate(): LastUpdateEntity?
}