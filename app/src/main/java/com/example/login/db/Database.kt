package com.example.login.db

import android.content.Context

class Database (context: Context) {

    private val dbHelper: DbHelper = DbHelper(context)

    fun crearUsuario(usuario: Usuario) {
        dbHelper.insertarUsuario(usuario)
    }

    fun crearReporte(id:String, latitud:String, longitud:String, tipoDeReporte:String, descripcion:String) {
        dbHelper.insertarReporte(id, latitud, longitud, tipoDeReporte, descripcion)
    }

    fun crearNoticia(noticia:Noticia) {
        dbHelper.insertarNoticia(noticia.id, noticia.title, noticia.description)
    }
    fun leerUsuarios(): List<Usuario> {
        return dbHelper.leerUsuarios()
    }
    fun leerNoticias(): List<Noticia> {
        return dbHelper.leerNoticias()
    }
    fun leerReportes(): List<Reports> {
        return dbHelper.leerReportes()
    }

    fun buscarUsuario(correo: String): Usuario? {
        return dbHelper.buscarUsuario(correo)
    }

    fun actualizarUsuario(usuario: Usuario) {
        dbHelper.actualizarUsuario(usuario)
    }

    fun eliminarUsuario(id: Int) {
        dbHelper.eliminarUsuario(id)
    }
}