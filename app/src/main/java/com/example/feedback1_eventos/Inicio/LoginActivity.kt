// LoginActivity.kt
package com.example.feedback1_eventos.Inicio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.feedback1_eventos.LoginScreen
import com.example.feedback1_eventos.Base_datos.UserManager

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(
                onLogin = { username: String, password: String, showMessage ->
                    UserManager.getUser(username, password) { user ->
                        if (user != null) {
                            val intent = Intent(this, MenuUsuarioActivity::class.java)
                            intent.putExtra("username", user.username)
                            startActivity(intent)
                            finish()
                        } else {
                            showMessage("Invalid username or password")
                        }
                    }
                },
                onRegister = { username: String, password: String, showMessage ->
                    UserManager.registerUser(username, password) { success ->
                        if (success) {
                            showMessage("User registered successfully")
                            val intent = Intent(this, MenuUsuarioActivity::class.java)
                            intent.putExtra("username", username)
                            startActivity(intent)
                            finish()
                        } else {
                            showMessage("Registration failed")
                        }
                    }
                }
            )
        }
    }
}