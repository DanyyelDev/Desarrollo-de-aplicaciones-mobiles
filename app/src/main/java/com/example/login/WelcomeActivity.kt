package com.example.login


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class WelcomeActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val buttonMapa = findViewById<Button>(R.id.buttonMapa)
        val buttonReports = findViewById<Button>(R.id.buttonReportes)

        buttonMapa.setOnClickListener {
            // Realiza la acción para el botón mapa
            val intent = Intent(this, MapView::class.java)
            startActivity(intent)
        }

        buttonReports.setOnClickListener {
            val intent = Intent(this, Reports::class.java)
            startActivity(intent)
        }
    }
}