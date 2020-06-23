package br.com.hellopetdesign.data.models

import br.com.hellopetdesign.domain.model.Product

fun getMockProduct(id: Long) : Product {
    return Product(id, id.toString(), emptyList())
}