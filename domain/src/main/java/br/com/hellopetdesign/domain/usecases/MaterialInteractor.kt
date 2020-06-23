package br.com.hellopetdesign.domain.usecases

import br.com.hellopetdesign.domain.model.Material
import br.com.hellopetdesign.domain.repository.IMaterialRepository

class MaterialInteractor(
    private val materialRepository: IMaterialRepository
) : IMaterialInteractor {
    override suspend fun getAllMaterial(): List<Material> {
        return materialRepository.getAllMaterials()
    }
}