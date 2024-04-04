package com.example.myapplication.data.user

object GitHubUserRepositoryFactory {

    fun create() : GitHubUserRepository = GitHubUserRepositoryImpl()
}