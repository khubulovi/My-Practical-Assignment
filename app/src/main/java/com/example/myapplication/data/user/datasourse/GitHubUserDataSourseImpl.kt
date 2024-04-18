package com.example.myapplication.data.user.datasourse

import com.example.myapplication.data.api.GitHubApi
import com.example.myapplication.data.user.GitHubUser
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class GitHubUserDataSourseImpl(
    private val gitHubApi: GitHubApi
) : GitHubUserDataSourse {
    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubApi
            .fetchUsers()
            .delay(2L,TimeUnit.SECONDS)

    override fun getUserByLogin(login: String): Maybe<GitHubUser>  =
        gitHubApi
            .fetchUserByLogin(login)
            .onErrorComplete()
}