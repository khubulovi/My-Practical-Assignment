package com.example.myapplication.data.user.datasourse

import com.example.myapplication.data.user.GitHubUser
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GitHubUserCacheDataSourse {
    fun getUsers(): Observable<List<GitHubUser>>
    fun getUserByLogin(login: String): Observable<GitHubUser>
    fun retain(users: List<GitHubUser>): Observable<List<GitHubUser>>
    fun retain(user: GitHubUser): Single<GitHubUser>
}