package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.data.room.RoomDb
import br.com.hellopetdesign.domain.model.Material
import kotlinx.coroutines.flow.first

class LocalMaterialDataSource(roomDb: RoomDb) : IMaterialDataSource {
    private val appDatabase = roomDb.localDatabase

    override suspend fun getAllMaterials(): List<Material> {
        return appDatabase.materialDao().getAllMaterials().first().map {
            Material(
                materialId = it.materialId,
                name = it.name,
                supplierId = it.supplierId.toInt(),
                supplier = null
            )
        }
    }
}