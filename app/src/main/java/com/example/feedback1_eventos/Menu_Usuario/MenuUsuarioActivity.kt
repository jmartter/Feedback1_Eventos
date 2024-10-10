// MenuUsuarioActivity.kt
package com.example.feedback1_eventos.Inicio

import MenuUsuarioContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MenuUsuarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userName = intent.getStringExtra("username") ?: "User"
        setContent {
            MenuUsuarioContent(userName)
        }
    }
}