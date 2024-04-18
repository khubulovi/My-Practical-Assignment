package com.example.myapplication.data.user.datasourse

import com.example.myapplication.data.user.GitHubUser
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface GitHubUserDataSourse {
    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(login: String): Maybe<GitHubUser>
}