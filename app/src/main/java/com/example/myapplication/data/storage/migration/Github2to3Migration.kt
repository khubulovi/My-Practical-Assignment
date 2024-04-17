package com.example.myapplication.data.storage.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Github2to3Migration : Migration (2,3) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE github_users ADD COLUMN name TEXT DEFAULT NULL")
    }
}