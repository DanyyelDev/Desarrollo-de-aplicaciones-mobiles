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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.db.Database
import com.example.login.db.DbManager
import com.example.login.db.Noticia
import com.example.login.db.adapters.NoticiaAdapter
import java.util.UUID

class Novedades : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var database: Database

    private lateinit var personasQueTransitan: EditText
    private lateinit var numeroDeAccidentes: EditText
    private lateinit var heridos: EditText
    private lateinit var fallecidos: EditText
    private lateinit var tipoDeActorInvolucrado: EditText

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novedades)

        database = DbManager.getDbHelper()

        personasQueTransitan = findViewById(R.id.personasquetransitan)
        numeroDeAccidentes = findViewById(R.id.numeroaccidentesmes)
        heridos = findViewById(R.id.heridos)
        fallecidos = findViewById(R.id.fallecidos)
        tipoDeActorInvolucrado = findViewById(R.id.tipoactorinvolucrado)

        val reportButton = findViewById<Button>(R.id.buttonReportsEstadisticas)
        reportButton.setOnClickListener{

            val id = UUID.randomUUID().toString()
            val PersonasQueTransitandb = personasQueTransitan.text.toString()
            val NumeroDeAccidentesdb = numeroDeAccidentes.text.toString()
            val heridosdb = heridos.text.toString()
            val fallecidosdb = fallecidos.text.toString()
            val tipoDeActorInvolucradodb = tipoDeActorInvolucrado.text.toString()



            // Realizar la lógica de registro (en este caso, almacenar en la base de datos local)

            if (database.crearReporteEstadisticas(id, PersonasQueTransitandb, NumeroDeAccidentesdb, heridosdb, fallecidosdb, tipoDeActorInvolucradodb) != null) {
                Toast.makeText(this, "Registro del reporte exitoso", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Registro fallido", Toast.LENGTH_SHORT).show()
            }

        }
    }


}