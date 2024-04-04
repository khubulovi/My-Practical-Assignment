package com.example.myapplication.data.user

interface GitHubUserRepository {
    fun getUsers(): List<GitHubUser>

    fun getUsersByLogin(userId: String): GitHubUser?
}