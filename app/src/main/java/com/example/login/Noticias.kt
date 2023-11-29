package com.example.login

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.db.Database
import com.example.login.db.DbManager
import com.example.login.db.Noticia
import com.example.login.db.adapters.NoticiaAdapter

class Noticias : AppCompatActivity() {
    var database: Database = DbManager.getDbHelper()
    val resultados:List<Noticia> =resultadosDB(database)

    fun resultadosDB(db: Database):List<Noticia>{
        return db.leerNoticias()
    }



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)
        initRecyclerView()
    }
    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerNews)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NoticiaAdapter(resultados)
    }
}