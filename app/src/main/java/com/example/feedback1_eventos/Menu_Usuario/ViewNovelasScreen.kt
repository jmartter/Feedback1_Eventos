import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import kotlinx.coroutines.launch
import com.example.feedback1_eventos.Base_datos.Novela

@Composable
fun ViewNovelasScreen(novelas: List<Novela>, onBack: () -> Unit, modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var selectedNovela by remember { mutableStateOf<Novela?>(null) }

    Scaffold { innerPadding ->
        Box(
            modifier = modifier
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
                    .padding(start = 16.dp, end = 16.dp, top = 64.dp)
            ) {
                LazyColumn(
                    state = listState,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(novelas) { novela ->
                        Column(
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .clickable { selectedNovela = novela }
                        ) {
                            Text(text = novela.titulo, fontSize = 16.sp, modifier = Modifier.padding(bottom = 4.dp))
                            Text(text = "Autor: ${novela.autor}", fontSize = 14.sp, modifier = Modifier.padding(bottom = 4.dp))
                            Text(text = "Año: ${novela.anoPublicacion}", fontSize = 14.sp, modifier = Modifier.padding(bottom = 4.dp))
                            Text(text = "Sinopsis: ${novela.sinopsis}", fontSize = 14.sp, modifier = Modifier.padding(bottom = 8.dp))
                            Divider()
                        }
                    }
                }
            }
            Column(
                modifier = Modifier.align(Alignment.TopEnd).padding(16.dp)
            ) {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            val newIndex = (listState.firstVisibleItemIndex - 1).coerceAtLeast(0)
                            listState.animateScrollToItem(newIndex)
                        }
                    }
                ) {
                    Icon(Icons.Filled.ArrowDropUp, contentDescription = "Scroll Up")
                }
                Spacer(modifier = Modifier.height(8.dp))
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            val newIndex = (listState.firstVisibleItemIndex + 1).coerceAtMost(novelas.size - 1)
                            listState.animateScrollToItem(newIndex)
                        }
                    }
                ) {
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = "Scroll Down")
                }
            }
        }
    }

    selectedNovela?.let { novela ->
        AlertDialog(
            onDismissRequest = { selectedNovela = null },
            title = { Text(text = "Opciones para ${novela.titulo}") },
            text = {
                Column {
                    TextButton(onClick = { /* Lógica para borrar la novela */ }) {
                        Text("Borrar")
                    }
                    TextButton(onClick = { /* Lógica para añadir reseña */ }) {
                        Text("Añadir Reseña")
                    }
                    TextButton(onClick = { /* Lógica para añadir a favoritos */ }) {
                        Text("Añadir a Favoritos")
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { selectedNovela = null }) {
                    Text("Cerrar")
                }
            }
        )
    }
}