package com.example.login.db.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.db.Reports

class ReporteViewHolder(view: View): RecyclerView.ViewHolder(view){

    val latitud = view.findViewById<TextView>(R.id.reportesLatitud)
    val longitud = view.findViewById<TextView>(R.id.reportesLongitud)
    val tipoDeReporte = view.findViewById<TextView>(R.id.reporteType)
    val des = view.findViewById<TextView>(R.id.reporteDescription)
    fun render (reports: Reports){
        latitud.text = reports.latitud
        longitud.text = reports.longitud
        tipoDeReporte.text = reports.tipoDeReporte
        des.text = reports.descripcion

    }
}