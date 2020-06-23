package br.com.hellopetdesign.domain.repository

import br.com.hellopetdesign.domain.model.Material

interface IMaterialRepository {
    suspend fun getAllMaterials(): List<Material>
}