package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.data.room.Database
import br.com.hellopetdesign.data.room.daos.ProductDao
import br.com.hellopetdesign.data.room.entities.ProductEntity
import br.com.hellopetdesign.domain.model.Material
import br.com.hellopetdesign.domain.model.Product
import br.com.hellopetdesign.domain.model.ProductMaterial
import br.com.hellopetdesign.domain.model.Supplier
import kotlinx.coroutines.flow.first

class LocalProductDataSource(database: Database) : IProductDataSource {
    private val appDatabase = database.localDatabase
    private val productDao: ProductDao = appDatabase.productDao()

    override suspend fun add(product: Product) {
        product.productId = productDao.insert(ProductEntity(name = product.name))
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
                productEntity.name,
                productMaterialList.map {
                    val m = appDatabase.materialDao().getMaterialWithSupplier(it.materialId).first()

                    ProductMaterial(
                        material = Material(
                            m.materialEntity.materialId,
                            m.materialEntity.name,
                            Supplier(
                                m.supplierEntity.supplierId,
                                m.supplierEntity.name,
                                m.supplierEntity.address
                            )
                        ),
                        quantity = it.quantity
                    )
                })
        }
    }
}