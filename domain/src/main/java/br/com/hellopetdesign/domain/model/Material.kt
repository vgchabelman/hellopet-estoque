package br.com.hellopetdesign.domain.model

data class Material(
    val materialId: Int,
    val name: String,
    val supplierId: Int?,
    val supplier: Supplier?
)