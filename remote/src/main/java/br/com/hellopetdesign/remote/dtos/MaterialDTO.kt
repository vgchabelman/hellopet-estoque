package br.com.hellopetdesign.remote.dtos

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.PropertyName

data class MaterialDTO(
    @DocumentId val id: String = "",
    val name: String = "",
    @PropertyName("supplier_id") val supplierId: Int = 0,
    val inventory: Int = 0
)