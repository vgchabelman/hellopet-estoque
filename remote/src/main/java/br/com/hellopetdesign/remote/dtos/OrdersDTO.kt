package br.com.hellopetdesign.data.remote.dtos

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class OrdersDTO(
    @DocumentId val id: String = "",
    val client: String = "",
    val products: List<Map<String, Int>> = emptyList(),
    @ServerTimestamp val shippingDate: Date = Calendar.getInstance().time
)