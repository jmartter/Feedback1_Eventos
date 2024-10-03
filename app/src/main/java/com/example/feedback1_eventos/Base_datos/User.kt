// User.kt
package com.example.feedback1_eventos.Base_datos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val username: String = "",
    val password: String = "",
    val novelas: MutableList<Novela> = mutableListOf()
) {
    // No-argument constructor for Firestore
    constructor() : this("", "", mutableListOf())
}