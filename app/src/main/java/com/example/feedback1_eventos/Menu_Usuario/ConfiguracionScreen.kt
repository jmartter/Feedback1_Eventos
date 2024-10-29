package com.example.feedback1_eventos

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConfiguracionScreen(onBack: () -> Unit) {
    var isDarkTheme by remember { mutableStateOf(false) }

    MaterialTheme(
        colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()
    ) {
        Scaffold { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.align(Alignment.Start).padding(16.dp)
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { isDarkTheme = !isDarkTheme }) {
                        Text(text = if (isDarkTheme) "Switch to Light Mode" else "Switch to Dark Mode")
                    }
                }
            }
        }
    }
}