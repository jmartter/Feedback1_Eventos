// MenuUsuarioActivity.kt
package com.example.feedback1_eventos.Inicio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.feedback1_eventos.MenuUsuarioScreen

class MenuUsuarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userName = intent.getStringExtra("username") ?: "User" // Retrieve the username
        setContent {
            MenuUsuarioScreen(
                userName = userName,
                onBack = {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            )
        }
    }
}