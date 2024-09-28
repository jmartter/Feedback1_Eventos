import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.feedback1_eventos.Base_datos.Novela

@Composable
fun NovelOptionsDialog(novela: Novela, onDismiss: () -> Unit, onDelete: () -> Unit, onView: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Opciones para ${novela.titulo}") },
        text = {
            Column {
                TextButton(onClick = onDelete) { Text("Borrar") }
                TextButton(onClick = { /* Lógica para añadir reseña */ }) { Text("Añadir Reseña") }
                TextButton(onClick = { /* Lógica para añadir a favoritos */ }) { Text("Añadir a Favoritos") }
                TextButton(onClick = onView) { Text("Ver") }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Cerrar") }
        }
    )
}