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

    fun leerUsuarios(): List<Usuario> {
        return dbHelper.leerUsuarios()
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