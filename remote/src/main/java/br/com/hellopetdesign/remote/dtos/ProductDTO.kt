package br.com.hellopetdesign.remote.dtos

import com.google.firebase.firestore.DocumentId

data class ProductDTO(
    @DocumentId val id: String = "",
    val name: String = "",
    val materials: List<Map<String, Double>> = emptyList(),
    val inventory: Int = 0
)