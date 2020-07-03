package br.com.hellopetdesign.remote

import android.util.Log
import br.com.hellopetdesign.remote.dtos.LastUpdatesDTO
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException

class FirebaseRemote {
    var lastUpdates: LastUpdatesDTO? = null

    init {
        FirebaseFirestore.getInstance().collection(LAST_UPDATES_COLLECTION)
            .document("collections")
            .addSnapshotListener { snapshot: DocumentSnapshot?, e: FirebaseFirestoreException? ->
                e?.let {
                    Log.e("Hellopet", e.message.toString())
                    return@addSnapshotListener
                }

                if (snapshot?.exists() == true) {
                    lastUpdates
                }
            }
    }

    fun getProductCollection(): CollectionReference {
        return FirebaseFirestore.getInstance().collection(PRODUCT_COLLECTION)
    }

    fun getMaterialCollection(): CollectionReference {
        return FirebaseFirestore.getInstance().collection(MATERIAL_COLLECTION)
    }

    fun getOrderCollection(): CollectionReference {
        return FirebaseFirestore.getInstance().collection(ORDERS_COLLECTION)
    }

    companion object {
        const val PRODUCT_COLLECTION = "products"
        const val MATERIAL_COLLECTION = "materials"
        const val SUPPLIER_COLLECTION = "suppliers"
        const val LAST_UPDATES_COLLECTION = "last-updates"
        const val ORDERS_COLLECTION = "orders"
    }
}