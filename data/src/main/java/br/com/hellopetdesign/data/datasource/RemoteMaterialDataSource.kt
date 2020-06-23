package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.data.remote.MATERIAL_COLLECTION
import br.com.hellopetdesign.data.remote.dtos.MaterialDTO
import br.com.hellopetdesign.domain.model.Material
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RemoteMaterialDataSource : IMaterialDataSource {
    override suspend fun getAllProducts(): List<Material> {
        val m = FirebaseFirestore.getInstance().collection(MATERIAL_COLLECTION)
            .get()
            .await()
        return m.toObjects(MaterialDTO::class.java).map {
            Material(
                materialId = it.id.toInt(),
                name = it.name,
                supplierId = it.supplierId,
                supplier = null
            )
        }
    }
}