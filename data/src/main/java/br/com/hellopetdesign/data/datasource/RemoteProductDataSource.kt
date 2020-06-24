package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.data.remote.FirebaseRemote
import br.com.hellopetdesign.data.remote.dtos.ProductDTO
import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.model.ProductMaterial
import com.google.firebase.firestore.ktx.toObjects
import kotlinx.coroutines.tasks.await

class RemoteProductDataSource(
    private val firebaseRemote: FirebaseRemote
) : IProductDataSource {
    @ExperimentalStdlibApi
    override suspend fun add(product: Product) {
        val materials = product.materials.map {
            buildMap<String, Double> {
                put("material_id", it.material?.materialId?.toDouble() ?: 1.0)
                put("quantity", it.quantity)
            }
        }
        val p = ProductDTO(product.productId.toString(), product.name, materials)
        firebaseRemote.getProductCollection()
            .document(p.id)
            .set(p)
    }

    @ExperimentalStdlibApi
    override suspend fun add(products: List<Product>) {
        products.forEach {
            this.add(it)
        }
    }

    override suspend fun remove(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllProducts(): List<Product> {
        val querySnapshot = firebaseRemote.getProductCollection()
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

    override suspend fun getProductLastUpdate(): Int {
        return firebaseRemote.lastUpdates?.products ?: -1
    }

    override suspend fun updateProductLastUpdate(index: Int) {
        firebaseRemote.lastUpdates?.products = index
    }
}