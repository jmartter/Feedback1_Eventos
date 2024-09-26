// LoginActivity.kt
package com.example.feedback1_eventos.Inicio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.feedback1_eventos.LoginScreen
import com.example.feedback1_eventos.MainActivity
import com.example.feedback1_eventos.Base_datos.UserManager

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(
                onLogin = { username: String, password: String, showMessage ->
                    val user = UserManager.getUser(username, password)
                    if (user != null) {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        showMessage("User not found")
                    }
                }
            )
        }
    }
}