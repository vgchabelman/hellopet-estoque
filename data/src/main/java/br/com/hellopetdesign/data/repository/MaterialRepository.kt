package br.com.hellopetdesign.data.repository

import br.com.hellopetdesign.data.datasource.IMaterialDataSource
import br.com.hellopetdesign.domain.model.Material
import br.com.hellopetdesign.domain.repository.IMaterialRepository

class MaterialRepository(
    private val localMaterialDataSource: IMaterialDataSource,
    private val remoteMaterialDataSource: IMaterialDataSource
): IMaterialRepository{
    override suspend fun getAllMaterials(): List<Material> {
        return remoteMaterialDataSource.getAllMaterials()
    }

}