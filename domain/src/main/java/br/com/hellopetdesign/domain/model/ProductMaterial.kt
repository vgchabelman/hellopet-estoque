package br.com.hellopetdesign.domain.model

data class ProductMaterial(
    var material: Material? = null,
    var materialId: Int? = null,
    val quantity: Double
)