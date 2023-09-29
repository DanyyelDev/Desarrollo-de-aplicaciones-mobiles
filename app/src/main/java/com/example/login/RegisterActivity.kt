package com.example.login


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.db.Database
import com.example.login.db.DbManager
import com.example.login.db.Usuario
import com.google.firebase.FirebaseApp
import java.util.UUID


class RegisterActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var database: Database

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        FirebaseApp.initializeApp(this)

        database = DbManager.getDbHelper()
        println(database)
        nameEditText = findViewById(R.id.name)
        emailEditText = findViewById(R.id.correoElectrónico)
        passwordEditText = findViewById(R.id.password)
        confirmPasswordEditText = findViewById(R.id.comfirmPassword)

        val registerButton = findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener {

            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            // Valida los datos de registro
            if (name.isEmpty()) {
                Toast.makeText(this, "El nombre es obligatorio", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                Toast.makeText(this, "El correo electrónico es obligatorio", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "La contraseña es obligatoria", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden"+UUID.randomUUID().toString(), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Realizar la lógica de registro (en este caso, almacenar en la base de datos local)
            // Realizar la lógica de registro (en este caso, almacenar en la base de datos local)
            val usuario = Usuario( UUID.randomUUID().toString(), name, email, password)
            if (database.crearUsuario(usuario) != null) {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Registro fallido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}