// Novela.kt
package com.example.feedback1_eventos.Base_datos

data class Novela(
    val titulo: String,
    val autor: String,
    val anoPublicacion: Int,
    val sinopsis: String,
    var isFavorite: Boolean = false
)