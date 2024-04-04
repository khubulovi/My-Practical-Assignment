package com.example.myapplication.data.user

class GitHubUserRepositoryImpl : GitHubUserRepository {
    private val users = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5"),
    )

    override fun getUsers() = users

    override fun getUsersByLogin(userId: String): GitHubUser? =
        users.firstOrNull { user -> user.login == userId }
}