package com.example.myapplication.data.user.datasourse

import com.example.myapplication.data.storage.GitHubStorage
import com.example.myapplication.data.user.GitHubUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class GitHubUserCacheDataSourseImpl(
    private val gitHubStorage: GitHubStorage
) : GitHubUserCacheDataSourse {
    override fun getUsers(): Observable<List<GitHubUser>>  =
        gitHubStorage
            .getGitHubUserDao()
            .getUsers()

    override fun getUserByLogin(login: String): Observable<GitHubUser> =
        gitHubStorage
            .getGitHubUserDao()
            .getUserByLogin(login)

    override fun retain(users: List<GitHubUser>): Observable<List<GitHubUser>> =
        gitHubStorage
            .getGitHubUserDao()
            .retain(users)
            .andThen(
                gitHubStorage
                    .getGitHubUserDao()
                    .getUsers()
            )

    override fun retain(user: GitHubUser): Single<GitHubUser> =
        gitHubStorage
            .getGitHubUserDao()
            .retain(user)
            .andThen(
                gitHubStorage
                    .getGitHubUserDao()
                    .getUserByLogin(user.login)
                    .firstOrError()
            )
}