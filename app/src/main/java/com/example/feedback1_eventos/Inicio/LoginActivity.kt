package com.example.feedback1_eventos.Inicio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.feedback1_eventos.Base_datos.AppDatabase
import com.example.feedback1_eventos.LoginScreen
import com.example.feedback1_eventos.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(
                onLogin = { username: String, password: String ->
                    lifecycleScope.launch {
                        val db = AppDatabase.getDatabase(this@LoginActivity)
                        val userDao = db.userDao()
                        val user = withContext(Dispatchers.IO) {
                            userDao.getUser(username, password)
                        }
                        if (user != null) {
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            // Maneja el error de inicio de sesión
                        }
                    }
                }
            )
        }
    }
}