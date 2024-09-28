// NewUserScreen.kt
package com.example.feedback1_eventos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NewUserScreen(onBack: () -> Unit, onUserCreated: (String) -> Unit, modifier: Modifier = Modifier, viewModel: NewUserViewModel = viewModel()) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Nuevo Usuario", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
        OutlinedTextField(
            value = viewModel.username,
            onValueChange = { viewModel.username = it },
            label = { Text("Nombre de Usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = viewModel.password,
            onValueChange = { viewModel.password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.createUser(onUserCreated) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear Usuario")
        }
        viewModel.message?.let {
            Snackbar(
                action = {
                    Button(onClick = { viewModel.message = null }) {
                        Text("Dismiss")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) { Text(it) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewUserScreenPreview() {
    NewUserScreen(onBack = {}, onUserCreated = {})
}