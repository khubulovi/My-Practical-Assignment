package com.example.myapplication.data.user

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {
    fun getUsers(): Single<List<GitHubUser>>

    fun getUsersByLogin(userId: String): Maybe<GitHubUser>
}