// MenuUsuarioScreen.kt
package com.example.feedback1_eventos

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.feedback1_eventos.Inicio.LoginActivity

@Composable
fun MenuUsuarioScreen(userName: String, onBack: () -> Unit, onAddNovela: () -> Unit, onViewUserNovelas: () -> Unit, onViewInitialNovelas: () -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Scaffold { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            IconButton(
                onClick = {
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.align(Alignment.TopStart).padding(16.dp)
            ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Welcome to MenuUsuario, $userName", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
                Button(
                    onClick = onAddNovela,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                ) {
                    Text("Añadir Novela")
                }
                Button(
                    onClick = onViewUserNovelas,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                ) {
                    Text("Ver Mis Novelas")
                }
                Button(
                    onClick = onViewInitialNovelas,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                ) {
                    Text("Ver Otras Novelas")
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuUsuarioScreenPreview() {
    MenuUsuarioScreen(userName = "User", onBack = {}, onAddNovela = {}, onViewUserNovelas = {}, onViewInitialNovelas = {})
}