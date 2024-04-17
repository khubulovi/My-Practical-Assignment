package com.example.myapplication.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.repository.GitHubRepository
import com.example.myapplication.data.user.GitHubUser

@Database(exportSchema = false, entities = [GitHubUser::class, GitHubRepository::class], version = 1)
abstract class GitHubStorage : RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao
    abstract fun getGitHubRepositoryDao(): GitHubRepositoryDao

}