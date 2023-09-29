package com.example.login.db

import android.content.Context

object DbManager {
    private var database: Database? = null

    fun initialize(context: Context) {
        if (database == null) {
            database = Database(context)
        }
    }

    fun getDbHelper(): Database {
        return database ?: throw IllegalStateException("Database must be initialized first.")
    }
}