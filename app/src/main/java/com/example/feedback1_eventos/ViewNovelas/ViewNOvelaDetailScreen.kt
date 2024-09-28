import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.example.feedback1_eventos.Base_datos.Novela

@Composable
fun ViewNovelaDetailScreen(novela: Novela, onBack: () -> Unit) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            IconButton(
                onClick = onBack,
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
                Text(text = novela.titulo, fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
                Text(text = "Autor: ${novela.autor}", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
                Text(text = "Año de Publicación: ${novela.anoPublicacion}", fontSize = 20.sp, modifier = Modifier.padding(bottom = 8.dp))
                Text(text = "Sinopsis: ${novela.sinopsis}", fontSize = 16.sp, modifier = Modifier.padding(bottom = 8.dp))
            }
        }
    }
}