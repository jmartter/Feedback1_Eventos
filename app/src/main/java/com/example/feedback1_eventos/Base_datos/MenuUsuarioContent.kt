import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.feedback1_eventos.AddNovelaScreen
import com.example.feedback1_eventos.Base_datos.Novela
import com.example.feedback1_eventos.Base_datos.UserManager
import com.example.feedback1_eventos.MenuUsuarioScreen

@Composable
fun MenuUsuarioContent(userName: String) {
    var showAddNovelaScreen by remember { mutableStateOf(false) }
    var showUserNovelasScreen by remember { mutableStateOf(false) }
    var novelas by remember { mutableStateOf<List<Novela>>(emptyList()) }

    if (showUserNovelasScreen) {
        UserManager.getNovelasForUser(userName) { fetchedNovelas ->
            novelas = fetchedNovelas ?: emptyList()
        }
    }

    when {
        showAddNovelaScreen -> {
            AddNovelaScreen(
                onBack = { showAddNovelaScreen = false },
                onAddNovela = { novela ->
                    UserManager.addNovelaToUser(userName, novela)
                    showAddNovelaScreen = false
                }
            )
        }
        showUserNovelasScreen -> {
            ViewNovelasScreen(
                novelas = novelas,
                onBack = { showUserNovelasScreen = false },
                onDeleteNovela = { novela ->
                    UserManager.deleteNovelaFromUser(userName, novela)
                }
            )
        }
        else -> {
            MenuUsuarioScreen(
                userName = userName,
                onBack = {
                    // Handle back action
                },
                onAddNovela = { showAddNovelaScreen = true },
                onViewUserNovelas = { showUserNovelasScreen = true }
            )
        }
    }
}