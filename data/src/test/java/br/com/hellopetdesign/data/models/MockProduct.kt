package br.com.hellopetdesign.data.models

fun getMockProduct(id: Long) : Product {
    return Product(id, id.toString(), emptyList())
}