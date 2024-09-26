// UserManager.kt
package com.example.feedback1_eventos.Base_datos

import com.example.feedback1_eventos.User

object UserManager {
    private val users = mutableListOf<User>()

    init {
        // Agrega un usuario por defecto
        users.add(User("1", "1"))
    }

    fun addUser(user: User) {
        users.add(user)
    }

    fun getUser(username: String, password: String): User? {
        return users.find { it.username == username && it.password == password }
    }
}