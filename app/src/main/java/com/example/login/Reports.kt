package com.example.login

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.login.db.Database
import com.example.login.db.DbManager
import com.example.login.db.Usuario
import java.util.UUID

class Reports : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var database: Database

    private lateinit var latitudEditText: EditText
    private lateinit var longitudEditText: EditText
    private lateinit var descripcionEditText: EditText
    private lateinit var tipoDeReporteEditText: Spinner

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

        latitudEditText = findViewById(R.id.editTextLatitud)
        longitudEditText = findViewById(R.id.editTextLongitud)
        tipoDeReporteEditText = findViewById(R.id.spinner)
        descripcionEditText = findViewById(R.id.editTextDescripcion)

        val reportButton = findViewById<Button>(R.id.buttonReports)
        reportButton.setOnClickListener{

            val id = UUID.randomUUID().toString()
            val latitud = latitudEditText.text.toString()
            val longitud = longitudEditText.text.toString()
            val tipoDeReporte = spinner.selectedItem.toString()
            val descripcion = descripcionEditText.text.toString()

            // Valida los datos de registro
            if (latitud.isEmpty()) {
                Toast.makeText(this, "La latitud es obligatoria", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (longitud.isEmpty()) {
                Toast.makeText(this, "La longitud es obligatoria", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (tipoDeReporte.isEmpty()) {
                Toast.makeText(this, "El tipo de reporte es obligatorio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Realizar la lógica de registro (en este caso, almacenar en la base de datos local)
            // Realizar la lógica de registro (en este caso, almacenar en la base de datos local)
            if (database.crearReporte(id, latitud, longitud, tipoDeReporte, descripcion) != null) {
                Toast.makeText(this, "Registro del reporte exitoso", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Registro fallido", Toast.LENGTH_SHORT).show()
            }

        }
    }
}