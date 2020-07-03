package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.data.room.RoomDb
import br.com.hellopetdesign.data.room.daos.ProductDao
import br.com.hellopetdesign.data.room.entities.ProductEntity
import br.com.hellopetdesign.data.room.entities.ProductMaterialEntity
import br.com.hellopetdesign.domain.model.Material
import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.model.ProductMaterial
import br.com.hellopetdesign.domain.model.Supplier
import kotlinx.coroutines.flow.first

class LocalProductDataSource(private val roomDb: RoomDb) : IProductDataSource {
    private val appDatabase = roomDb.localDatabase
    private val productDao: ProductDao = appDatabase.productDao()

    override suspend fun add(product: Product) {
        product.productId = productDao.insert(ProductEntity(name = product.name))
        appDatabase.productMaterialDao().insert(product.materials.map {
            ProductMaterialEntity(
                productId = product.productId,
                materialId = it.materialId ?: 0,
                quantity = it.quantity
            )
        })
    }

    override suspend fun add(products: List<Product>) {
        productDao.insert(products.map {
            ProductEntity(it.productId, it.name)
        })
        products.forEach {product ->
            appDatabase.productMaterialDao().insert(product.materials.map {
                ProductMaterialEntity(
                    productId = product.productId,
                    materialId = it.materialId ?: 0,
                    quantity = it.quantity
                )
            })
        }
    }

    override suspend fun remove(product: Product) {
        productDao.delete(productDao.getProduct(product.productId).first())
    }

    override suspend fun getAllProducts(): List<Product> {
        return productDao.getAllProducts().first().map { productEntity ->
            val productMaterialDao = appDatabase.productMaterialDao()
            val productMaterialList =
                productMaterialDao.getMaterialsByProduct(productEntity.productId).first()

            return@map Product(productEntity.productId,
                name = productEntity.name,
                inventory = 1,
                materials = productMaterialList.map {
                    val m = appDatabase.materialDao().getMaterialWithSupplier(it.materialId).first()

                    ProductMaterial(
                        material = Material(
                            materialId = m.materialEntity.materialId,
                            name = m.materialEntity.name,
                            supplier = Supplier(
                                m.supplierEntity.supplierId,
                                m.supplierEntity.name,
                                m.supplierEntity.address
                            ),
                            supplierId = null,
                            inventory = 1
                        ),
                        quantity = it.quantity
                    )
                })
        }
    }

    override suspend fun getProductLastUpdate(): Int {
        return roomDb.localDatabase.lastUpdateDao().getLastUpdate()?.products ?: 1
    }

    override suspend fun updateProductLastUpdate(index: Int) {
        val last = roomDb.localDatabase.lastUpdateDao().getLastUpdate()
        last?.let {
            last.products = index
            roomDb.localDatabase.lastUpdateDao().update(last)
        }
    }
}