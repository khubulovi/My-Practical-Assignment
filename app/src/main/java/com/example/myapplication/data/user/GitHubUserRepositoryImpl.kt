package com.example.myapplication.data.user

import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GitHubUserRepository {
    private val users = listOf(
        GitHubUser("login1"),
        GitHubUser("login2"),
        GitHubUser("login3"),
        GitHubUser("login4"),
        GitHubUser("login5"),
    )

    override fun getUsers(): Single<List<GitHubUser>> =
        Single.just(users)

    override fun getUsersByLogin(userId: String): GitHubUser? =
        users.firstOrNull { user -> user.login == userId }
}