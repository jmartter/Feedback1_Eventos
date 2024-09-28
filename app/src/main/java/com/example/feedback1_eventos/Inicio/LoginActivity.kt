// LoginActivity.kt
package com.example.feedback1_eventos.Inicio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.feedback1_eventos.LoginScreen
import com.example.feedback1_eventos.NewUserScreen
import com.example.feedback1_eventos.Base_datos.UserManager

class LoginActivity : ComponentActivity() {
    private var showNewUserScreen = mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            if (showNewUserScreen.value) {
                NewUserScreen(
                    onBack = { showNewUserScreen.value = false },
                    onUserCreated = { username ->
                        val intent = Intent(this@LoginActivity, MenuUsuarioActivity::class.java)
                        intent.putExtra("username", username)
                        startActivity(intent)
                        finish()
                    }
                )
            } else {
                LoginScreen(
                    onLogin = { username: String, password: String, showMessage ->
                        val user = UserManager.getUser(username, password)
                        if (user != null) {
                            val intent = Intent(this@LoginActivity, MenuUsuarioActivity::class.java)
                            intent.putExtra("username", user.username)
                            startActivity(intent)
                            finish()
                        } else {
                            showMessage("User not found")
                        }
                    },
                    onNewUser = { showNewUserScreen.value = true }
                )
            }
        }
    }
}