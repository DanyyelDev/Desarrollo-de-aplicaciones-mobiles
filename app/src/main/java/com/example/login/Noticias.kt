package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.login.db.Database

class Noticias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var noticiasRecyclerView: RecyclerView
        var database: Database? = null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        noticiasRecyclerView = findViewById(R.id.contentNoticias)

        /* Obtener las noticias desde la base de datos

        database = DbManager.getDbHelper()
        database.insertarNoticia(Noticias(0,"Daño en la via", "Via #40 sin servicio", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nulla."))
        database.insertarNoticia(Noticias(1,"Trancón", "Via #40 trancada", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nulla."))
        database.insertarNoticia(Noticias(2,"Policia", "Via #40 policias en via", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nulla."))
        database.insertarNoticia(Noticias(3,"Disminución", "Via #40 disminucion ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nulla."))
        val noticiasList = database.leerNoticias()

        // Crear un adaptador y configurar el RecyclerView
        val noticiasAdapter = NoticiasAdapter(noticiasList)
        noticiasRecyclerView.adapter = noticiasAdapter
        noticiasRecyclerView.layoutManager = LinearLayoutManager(this)

         */
    }
}