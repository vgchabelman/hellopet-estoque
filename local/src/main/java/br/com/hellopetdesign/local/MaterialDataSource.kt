package br.com.hellopetdesign.local

import br.com.hellopetdesign.data.datasource.IMaterialDataSource
import br.com.hellopetdesign.domain.model.Material
import kotlinx.coroutines.flow.first

class MaterialDataSource(roomDb: RoomDb) : IMaterialDataSource {
    private val appDatabase = roomDb.localDatabase

    override suspend fun getAllMaterials(): List<Material> {
        return appDatabase.materialDao().getAllMaterials().first().map {
            Material(
                materialId = it.materialId,
                name = it.name,
                supplierId = it.supplierId.toInt(),
                supplier = null,
                inventory = 1
            )
        }
    }
}