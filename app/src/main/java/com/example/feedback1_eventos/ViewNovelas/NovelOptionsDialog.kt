// NovelOptionsDialog.kt
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import com.example.feedback1_eventos.Base_datos.Novela
import com.example.feedback1_eventos.Base_datos.UserManager

@Composable
fun NovelOptionsDialog(novela: Novela, onDismiss: () -> Unit, onDelete: () -> Unit, onView: () -> Unit, onToggleFavorite: () -> Unit, username: String) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Opciones para ${novela.titulo}") },
        text = {
            Column {
                TextButton(onClick = onDelete) { Text("Borrar") }
                TextButton(onClick = onView) { Text("Ver") }
                TextButton(onClick = {
                    UserManager.toggleFavorite(username, novela) { success ->
                        if (success) {
                            onToggleFavorite()
                        }
                    }
                }) {
                    Text(if (novela.isFavorite) "Quitar de Favoritos" else "Añadir a Favoritos")
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Cerrar") }
        }
    )
}