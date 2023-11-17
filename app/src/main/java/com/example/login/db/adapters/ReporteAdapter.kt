package com.example.login.db.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.db.Noticia
import com.example.login.db.Reports

class ReporteAdapter(private val reportes: List<Reports>): RecyclerView.Adapter<ReporteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReporteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ReporteViewHolder(layoutInflater.inflate(R.layout.reporte, parent, false))
    }

    override fun onBindViewHolder(holder: ReporteViewHolder, position: Int) {
        val item = reportes[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = reportes.size

}