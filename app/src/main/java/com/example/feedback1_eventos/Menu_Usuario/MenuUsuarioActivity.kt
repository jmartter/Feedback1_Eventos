// MenuUsuarioActivity.kt
package com.example.feedback1_eventos.Inicio

import ViewNovelasScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.feedback1_eventos.AddNovelaScreen
import com.example.feedback1_eventos.MenuUsuarioScreen
import com.example.feedback1_eventos.Base_datos.UserManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MenuUsuarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userName = intent.getStringExtra("username") ?: "User"
        setContent {
            MenuUsuarioContent(userName)
        }
    }
}

@Composable
fun MenuUsuarioContent(userName: String) {
    var showAddNovelaScreen by remember { mutableStateOf(false) }
    var showUserNovelasScreen by remember { mutableStateOf(false) }

    when {
        showAddNovelaScreen -> {
            AddNovelaScreen(
                onBack = { showAddNovelaScreen = false },
                onAddNovela = { novela ->
                    UserManager.addNovelaToUser(userName, novela)
                    showAddNovelaScreen = false
                }
            )
        }
        showUserNovelasScreen -> {
            ViewNovelasScreen(
                novelas = UserManager.getNovelasForUser(userName) ?: emptyList(),
                onBack = { showUserNovelasScreen = false },
                onDeleteNovela = { novela ->
                    UserManager.deleteNovelaFromUser(userName, novela)
                }
            )
        }
        else -> {
            MenuUsuarioScreen(
                userName = userName,
                onBack = {
                    // Handle back action
                },
                onAddNovela = { showAddNovelaScreen = true },
                onViewUserNovelas = { showUserNovelasScreen = true }
            )
        }
    }
}