// NewUserViewModel.kt
package com.example.feedback1_eventos

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.feedback1_eventos.Base_datos.User
import com.example.feedback1_eventos.Base_datos.UserManager

class NewUserViewModel : ViewModel() {
    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var message by mutableStateOf<String?>(null)

    fun createUser(onUserCreated: (String) -> Unit) {
        if (UserManager.isUsernameTaken(username)) {
            message = "Username already taken"
        } else {
            val newUser = User(username, password)
            UserManager.addUser(newUser)
            onUserCreated(username)
        }
    }
}