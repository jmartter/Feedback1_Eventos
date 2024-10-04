// UserManager.kt
package com.example.feedback1_eventos.Base_datos

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

object UserManager {
    private val db = FirebaseFirestore.getInstance()

    fun getUser(username: String, password: String, callback: (User?) -> Unit) {
        val userRef = db.collection("users").document(username)
        userRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val user = document.toObject(User::class.java)
                    if (user?.password == password) {
                        callback(user)
                    } else {
                        callback(null)
                    }
                } else {
                    callback(null)
                }
            }
            .addOnFailureListener {
                callback(null)
            }
    }

    fun registerUser(username: String, password: String, callback: (Boolean) -> Unit) {
        val user = User(username, password)
        val userRef = db.collection("users").document(username)
        userRef.set(user)
            .addOnSuccessListener { callback(true) }
            .addOnFailureListener { callback(false) }
    }

    fun addNovelaToUser(username: String, novela: Novela) {
        val userRef = db.collection("users").document(username)
        userRef.update("novelas", FieldValue.arrayUnion(novela))
    }

    fun deleteNovelaFromUser(username: String, novela: Novela) {
        val userRef = db.collection("users").document(username)
        userRef.update("novelas", FieldValue.arrayRemove(novela))
    }

    fun getNovelasForUser(username: String, callback: (List<Novela>?) -> Unit) {
        val userRef = db.collection("users").document(username)
        userRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val user = document.toObject(User::class.java)
                    callback(user?.novelas)
                } else {
                    callback(null)
                }
            }
            .addOnFailureListener {
                callback(null)
            }
    }

    fun toggleFavorite(username: String, novela: Novela, callback: (Boolean) -> Unit) {
        val userRef = db.collection("users").document(username)
        userRef.get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val user = document.toObject(User::class.java)
                    user?.let {
                        val updatedNovelas = it.novelas.map { n ->
                            if (n.titulo == novela.titulo) {
                                n.copy(isFavorite = !n.isFavorite)
                            } else {
                                n
                            }
                        }
                        userRef.update("novelas", updatedNovelas)
                            .addOnSuccessListener { callback(true) }
                            .addOnFailureListener { callback(false) }
                    } ?: callback(false)
                } else {
                    callback(false)
                }
            }
            .addOnFailureListener {
                callback(false)
            }
    }
}