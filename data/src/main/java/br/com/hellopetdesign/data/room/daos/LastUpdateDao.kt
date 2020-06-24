package br.com.hellopetdesign.data.room.daos

import androidx.room.Dao
import androidx.room.Query
import br.com.hellopetdesign.data.room.entities.LastUpdateEntity

@Dao
interface LastUpdateDao: GenericDao<LastUpdateEntity> {

    @Query("SELECT * FROM LAST_UPDATE LIMIT 1")
    suspend fun getLastUpdate(): LastUpdateEntity?
}