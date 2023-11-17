package com.example.login.db.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.db.Noticia

class NoticiaViewHolder(view: View): RecyclerView.ViewHolder(view){

    val id = view.findViewById<TextView>(R.id.noticiaid)
    val title = view.findViewById<TextView>(R.id.noticiaTitle)
    val des = view.findViewById<TextView>(R.id.noticiaDescription)
    fun render (noticia: Noticia){
        id.text = noticia.id
        title.text = noticia.title
        des.text = noticia.description

    }
}