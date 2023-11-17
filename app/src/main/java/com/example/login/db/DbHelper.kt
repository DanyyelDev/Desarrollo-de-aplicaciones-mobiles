package com.example.login.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_USUARIOS)
        db.execSQL(CREATE_TABLE_REPORTS)
        db.execSQL(CREATE_TABLE_NEWS)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        db.execSQL("DROP TABLE IF EXISTS reportes")
        onCreate(db)
    }

    fun insertarUsuario(usuario: Usuario) {
        val db = writableDatabase
        val values = ContentValues()
        values.put("id", usuario.id)
        values.put("nombre", usuario.nombre)
        values.put("correo", usuario.correo)
        values.put("contraseña", usuario.contrasena)
        db.insert("usuarios", null, values)
        db.close()
    }
    fun insertarReporte(id:String, latitud:String, longitud:String, tipoDeReporte:String, descripcion:String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put("id", id)
        values.put("latitud", latitud)
        values.put("longitud", longitud)
        values.put("tipoDeReporte", tipoDeReporte)
        values.put("descripcion", descripcion)
        db.insert("reports", null, values)
        db.close()
    }

    fun insertarNoticia(id:String, title:String, description:String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put("id", id)
        values.put("title", title)
        values.put("description", description)
        db.insert("news", null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun leerUsuarios(): List<Usuario> {
        val usuarios = mutableListOf<Usuario>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM usuarios", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex("id"))
                val nombre = cursor.getString(cursor.getColumnIndex("nombre"))
                val correo = cursor.getString(cursor.getColumnIndex("correo"))
                val contrasena = cursor.getString(cursor.getColumnIndex("contraseña"))
                usuarios.add(Usuario(id, nombre, correo, contrasena))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return usuarios
    }

    @SuppressLint("Range")
    fun leerReportes(): List<Reports> {
        val reportes = mutableListOf<Reports>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM reports", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex("id"))
                val latitud = cursor.getString(cursor.getColumnIndex("latitud"))
                val longitud = cursor.getString(cursor.getColumnIndex("longitud"))
                val tipoDeReporte = cursor.getString(cursor.getColumnIndex("tipoDeReporte"))
                val descripcion = cursor.getString(cursor.getColumnIndex("descripcion"))
                reportes.add(Reports(id, latitud, longitud, tipoDeReporte, descripcion))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return reportes
    }

    @SuppressLint("Range")
    fun leerNoticias(): List<Noticia> {
        val noticias = mutableListOf<Noticia>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM news", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndex("id"))
                val title = cursor.getString(cursor.getColumnIndex("title"))
                val description = cursor.getString(cursor.getColumnIndex("description"))
                noticias.add(Noticia(id, title, description))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return noticias
    }

    @SuppressLint("Range")
    fun buscarUsuario(correo: String): Usuario? {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM usuarios WHERE correo=?", arrayOf(correo))
        val usuario: Usuario? = if (cursor.moveToFirst()) {
            val id = cursor.getString(cursor.getColumnIndex("id"))
            val nombre = cursor.getString(cursor.getColumnIndex("nombre"))
            val contrasena = cursor.getString(cursor.getColumnIndex("contraseña"))
            Usuario(id, nombre, correo, contrasena)
        } else {
            null
        }
        cursor.close()
        db.close()
        return usuario
    }

    /**
    @SuppressLint("Range")
    fun buscarReportes(reportss: String): MutableList<Reports>? {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM reports", arrayOf(reportss))
        val listReports: MutableList<Reports>
        if (cursor.moveToFirst()) {
            val id = cursor.getString(cursor.getColumnIndex("id"))
            val latitud = cursor.getString(cursor.getColumnIndex("latitud"))
            val longitud = cursor.getString(cursor.getColumnIndex("longitud"))
            val tipoDeReporte = cursor.getString(cursor.getColumnIndex("tipoDeReporte"))
            val descripcion = cursor.getString(cursor.getColumnIndex("descripcion"))
            listReports.add(Reports(id, latitud, longitud, tipoDeReporte, descripcion))
        } else {
            null
        }
        cursor.close()
        db.close()
        return listReports
    }
    */

    fun actualizarUsuario(usuario: Usuario) {
        val db = writableDatabase
        val values = ContentValues()
        values.put("nombre", usuario.nombre)
        values.put("contraseña", usuario.contrasena)
        db.update("usuarios", values, "id=?", arrayOf(usuario.id.toString()))
        db.close()
    }

    fun eliminarUsuario(id: Int) {
        val db = writableDatabase
        db.delete("usuarios", "id=?", arrayOf(id.toString()))
        db.close()
    }

    companion object {
        const val DATABASE_NAME = "app.db"
        const val DATABASE_VERSION = 1

        const val CREATE_TABLE_USUARIOS = """
      CREATE TABLE usuarios (
        id TEXT,
        nombre TEXT,
        correo TEXT,
        contraseña TEXT
      );
    """

        const val CREATE_TABLE_REPORTS = """
      CREATE TABLE reports (
        id TEXT,
        latitud TEXT,
        longitud TEXT,
        tipoDeReporte TEXT,
        descripcion TEXT
      );
    """

        const val CREATE_TABLE_NEWS = """
      CREATE TABLE news (
        id TEXT,
        title TEXT,
        description TEXT
      );
    """
    }
}