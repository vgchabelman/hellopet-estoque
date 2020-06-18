package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.data.models.Material
import br.com.hellopetdesign.data.models.Product
import br.com.hellopetdesign.data.models.ProductMaterial
import br.com.hellopetdesign.data.models.Supplier
import br.com.hellopetdesign.data.room.AppDatabase
import br.com.hellopetdesign.data.room.daos.ProductDao
import br.com.hellopetdesign.data.room.entities.ProductEntity
import kotlinx.coroutines.flow.first

class LocalProductDataSource(private val appDatabase: AppDatabase) : IProductDataSource {
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
                        Material(
                            m.materialEntity.materialId,
                            m.materialEntity.name,
                            Supplier(
                                m.supplierEntity.supplierId,
                                m.supplierEntity.name,
                                m.supplierEntity.address
                            )
                        ),
                        it.quantity
                    )
                })
        }
    }
}