import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import com.example.feedback1_eventos.Base_datos.Novela

@Composable
fun ViewNovelasScreen(novelas: List<Novela>, onBack: () -> Unit, modifier: Modifier = Modifier, onDeleteNovela: (Novela) -> Unit) {
    var selectedNovela by remember { mutableStateOf<Novela?>(null) }
    var showNovelaDetail by remember { mutableStateOf(false) }

    if (showNovelaDetail && selectedNovela != null) {
        ViewNovelaDetailScreen(novela = selectedNovela!!, onBack = {
            showNovelaDetail = false
            selectedNovela = null
        })
    } else {
        Scaffold { innerPadding ->
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Column {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                    NovelList(novelas = novelas, onSelectNovela = { selectedNovela = it })
                }
            }
        }

        selectedNovela?.let { novela ->
            NovelOptionsDialog(
                novela = novela,
                onDismiss = { selectedNovela = null },
                onDelete = {
                    onDeleteNovela(novela)
                    selectedNovela = null
                },
                onView = { showNovelaDetail = true }
            )
        }
    }
}