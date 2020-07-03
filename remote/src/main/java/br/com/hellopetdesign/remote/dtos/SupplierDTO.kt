package br.com.hellopetdesign.remote.dtos

import com.google.firebase.firestore.DocumentId

data class SupplierDTO(
    @DocumentId val id: String = "",
    val name: String = "",
    val address: String = ""
)