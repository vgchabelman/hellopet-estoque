package br.com.hellopetdesign.remote

import br.com.hellopetdesign.data.datasource.IMaterialDataSource
import br.com.hellopetdesign.data.remote.dtos.MaterialDTO
import br.com.hellopetdesign.domain.model.Material
import kotlinx.coroutines.tasks.await

class MaterialDataSource(private val firebaseRemote: FirebaseRemote) : IMaterialDataSource {
    override suspend fun getAllMaterials(): List<Material> {
        val m = firebaseRemote.getMaterialCollection()
            .get()
            .await()
        return m.toObjects(MaterialDTO::class.java).map {
            Material(
                materialId = it.id.toInt(),
                name = it.name,
                supplierId = it.supplierId,
                supplier = null,
                inventory = it.inventory
            )
        }
    }
}