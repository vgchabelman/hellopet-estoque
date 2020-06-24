package br.com.hellopetdesign.data.datasource

import br.com.hellopetdesign.domain.model.Material

interface IMaterialDataSource {
    suspend fun getAllMaterials() : List<Material>
}