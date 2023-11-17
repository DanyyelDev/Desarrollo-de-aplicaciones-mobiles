package com.example.login


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class WelcomeActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val buttonMapa = findViewById<Button>(R.id.buttonMapa)
        val buttonNoticias = findViewById<Button>(R.id.buttonNoticias)
        val buttonReportes = findViewById<Button>(R.id.buttonReportes)

        buttonMapa.setOnClickListener {
            // Realiza la acción para el botón mapa
            val intent = Intent(this, MapView::class.java)
            startActivity(intent)
        }

        buttonNoticias.setOnClickListener {
            val intent = Intent(this, Noticias::class.java)
            startActivity(intent)
        }

        buttonReportes.setOnClickListener {
            val intent = Intent(this, ReportesView::class.java)
            startActivity(intent)
        }
    }
}