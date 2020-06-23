package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.data.remote.PRODUCT_COLLECTION
import br.com.hellopetdesign.data.remote.dtos.ProductDTO
import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.model.ProductMaterial
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.tasks.await

class RemoteProductDataSource : IProductDataSource {
    @ExperimentalStdlibApi
    override suspend fun add(product: Product) {
        val materials = product.materials.map {
            buildMap<String, Double> {
                put("material_id", it.material?.materialId?.toDouble() ?: 1.0)
                put("quantity", it.quantity)
            }
        }
        val p = ProductDTO(product.productId.toString(), product.name, materials)
        FirebaseFirestore.getInstance()
            .collection(PRODUCT_COLLECTION)
            .document(p.id)
            .set(p)
    }

    override suspend fun remove(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllProducts(): List<Product> {
        val querySnapshot = FirebaseFirestore.getInstance().collection(PRODUCT_COLLECTION)
            .get()
            .await()
        return querySnapshot.toObjects<ProductDTO>().map {
            Product(
                it.id.toLong(),
                it.name,
                it.materials.map { map ->
                    ProductMaterial(
                        materialId = map["material_id"]?.toInt(),
                        quantity = map["quantity"] ?: 0.0
                    )
                }
            )
        }
    }
}