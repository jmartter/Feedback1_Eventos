// UserManager.kt
package com.example.feedback1_eventos.Base_datos

object UserManager {
    private val users = mutableListOf<User>()

    fun addUser(user: User) {
        users.add(user)
    }

    fun getUser(username: String, password: String): User? {
        return users.find { it.username == username && it.password == password }
    }

    fun addNovelaToUser(username: String, novela: Novela) {
        val user = users.find { it.username == username }
        user?.novelas?.add(novela)
    }

    fun getNovelasForUser(username: String): List<Novela>? {
        return users.find { it.username == username }?.novelas
    }

    fun deleteNovelaFromUser(username: String, novela: Novela) {
        val user = users.find { it.username == username }
        user?.novelas?.remove(novela)
    }
}