package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.login.db.Database
import com.example.login.db.DbManager
import com.example.login.db.Usuario
import com.example.login.ui.theme.LoginTheme
import com.google.firebase.FirebaseApp
import java.util.UUID

class MainActivity : ComponentActivity() {
    private lateinit var database: Database

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.buttonLogin)
        val registerButton = findViewById<Button>(R.id.buttonRegister)
        DbManager.initialize(this)
        database = DbManager.getDbHelper()

        registerButton.setOnClickListener {
            val intent = Intent( this, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val correo = findViewById<EditText>(R.id.emailLogin).text.toString()
            val contrasena = findViewById<EditText>(R.id.passwordLogin).text.toString()

            // Valida los datos de ingreso
            if (correo.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Busca el usuario en la base de datos
            val usuario = database.buscarUsuario(correo)
            println(usuario)

            // Verifica si el usuario existe y la contraseña es correcta
            if (usuario != null && usuario.contrasena == contrasena) {
                // Inicia sesión
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            } else {
                // Muestra un mensaje de error
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginTheme {
        Greeting("Android")
    }
}