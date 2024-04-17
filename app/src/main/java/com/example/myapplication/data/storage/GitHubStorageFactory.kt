package com.example.myapplication.data.storage

import androidx.room.Room
import com.example.myapplication.PopularLabraries.ContextHolder.context
import com.example.myapplication.data.storage.migration.GitHub1to2Migration
import com.example.myapplication.data.storage.migration.Github2to3Migration

object GitHubStorageFactory {
    private val inMemoryDatabase: GitHubStorage by lazy {
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()
    }

    private val database: GitHubStorage by lazy {
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .addMigrations(GitHub1to2Migration)
            .addMigrations(Github2to3Migration)
            .build()
    }

    fun create(): GitHubStorage = database
}