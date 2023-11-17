package com.example.login

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.db.Database
import com.example.login.db.DbManager
import com.example.login.db.Reports
import com.example.login.db.adapters.ReporteAdapter

class ReportesView : AppCompatActivity() {
    var database: Database = DbManager.getDbHelper()
    val resultados:List<Reports> = resultadosDB(database)

    fun resultadosDB(db: Database):List<Reports>{
        return db.leerReportes()
    }
    /*
        database.crearNoticia(Noticia("","Daño en la via", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nulla."))
        database.crearNoticia(Noticia("","Trancón", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nulla."))
        database.crearNoticia(Noticia("","Policia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nulla."))
        database.crearNoticia(Noticia("","Disminución", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed nulla."))

        */
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        initRecyclerView()
    }
    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerNews)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ReporteAdapter(resultados)
    }
}