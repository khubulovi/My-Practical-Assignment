package com.example.myapplication.data.storage.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object GitHub1to2Migration : Migration(1,2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE github_user RENAME TO github_users")
        db.execSQL("ALTER TABLE github_users ADD COLUMN migrate_me TEXT DEFAULT NULL")
    }
}