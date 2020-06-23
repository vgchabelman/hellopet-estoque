package br.com.hellopetdesign.domain.usecases

import br.com.hellopetdesign.domain.model.Material

interface IMaterialInteractor {
    suspend fun getAllMaterial(): List<Material>
}