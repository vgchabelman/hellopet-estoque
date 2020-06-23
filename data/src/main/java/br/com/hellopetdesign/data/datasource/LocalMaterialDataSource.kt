package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.data.room.Database
import br.com.hellopetdesign.domain.model.Material
import kotlinx.coroutines.flow.first

class LocalMaterialDataSource(database: Database) : IMaterialDataSource {
    private val appDatabase = database.localDatabase

    override suspend fun getAllProducts(): List<Material> {
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