package com.example.login

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.example.login.db.Database
import com.example.login.db.DbManager
import java.util.UUID

class Reports : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var database: Database

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)

        database = DbManager.getDbHelper()

        val opciones = resources.getStringArray(R.array.spinner_tipo_reporte)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Manejar eventos de selección si es necesario
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Aquí puedes manejar la selección del usuario
                val opcionSeleccionada = opciones[position]
                Toast.makeText(this@Reports, "Opción seleccionada: $opcionSeleccionada", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No se ha seleccionado nada
            }
        }

        val reportButton = findViewById<Button>(R.id.buttonReports)
        reportButton.setOnClickListener{
            val id = UUID.randomUUID().toString()
            database.crearReporte(id,"123512412","124124141", "tipo 1", "Cierre vial villa del rio")
        }
    }
}