import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.feedback1_eventos.Base_datos.Novela

@Composable
fun NovelOptionsDialog(novela: Novela, onDismiss: () -> Unit, onDelete: () -> Unit, onView: () -> Unit, onToggleFavorite: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Opciones para ${novela.titulo}") },
        text = {
            Column {
                TextButton(onClick = onDelete) { Text("Borrar") }
                TextButton(onClick = { /* Lógica para añadir reseña */ }) { Text("Añadir Reseña") }
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