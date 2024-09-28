import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import com.example.feedback1_eventos.Base_datos.Novela

@Composable
fun NovelOptionsDialog(novela: Novela, onDismiss: () -> Unit, onDelete: () -> Unit, onView: () -> Unit, onToggleFavorite: () -> Unit, onAddReseña: (String) -> Unit) {
    var showAddReseñaDialog by remember { mutableStateOf(false) }
    var nuevaReseña by remember { mutableStateOf("") }

    if (showAddReseñaDialog) {
        AlertDialog(
            onDismissRequest = { showAddReseñaDialog = false },
            title = { Text(text = "Añadir Reseña") },
            text = {
                Column {
                    OutlinedTextField(
                        value = nuevaReseña,
                        onValueChange = { nuevaReseña = it },
                        label = { Text("Reseña") }
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    onAddReseña(nuevaReseña)
                    showAddReseñaDialog = false
                }) {
                    Text("Añadir")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAddReseñaDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Opciones para ${novela.titulo}") },
        text = {
            Column {
                TextButton(onClick = onDelete) { Text("Borrar") }
                TextButton(onClick = { showAddReseñaDialog = true }) { Text("Añadir Reseña") }
                TextButton(onClick = onView) { Text("Ver") }
                TextButton(onClick = onToggleFavorite) {
                    Text(if (novela.isFavorite) "Quitar de Favoritos" else "Añadir a Favoritos")
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Cerrar") }
        }
    )
}