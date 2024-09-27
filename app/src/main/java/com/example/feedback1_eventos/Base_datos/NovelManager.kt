// NovelaManager.kt
package com.example.feedback1_eventos.Base_datos

object NovelaManager {
    private val novelas = mutableListOf<Novela>()

    fun addNovela(novela: Novela) {
        novelas.add(novela)
    }

    fun getNovelas(): List<Novela> {
        return novelas
    }

    fun removeNovela(titulo: String) {
        novelas.removeIf { it.titulo == titulo }
    }

    fun getNovela(titulo: String): Novela? {
        return novelas.find { it.titulo == titulo }
    }
}