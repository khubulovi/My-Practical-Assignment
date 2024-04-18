package com.example.myapplication.data.user

import com.example.myapplication.data.repository.GitHubRepository
import io.reactivex.rxjava3.core.Observable

interface GitHubUserRepository {
    fun getUsers(): Observable<List<GitHubUser>>

    fun getUsersByLogin(userId: String): Observable<GitHubUser>

    fun getUserRepository(login : String) : Observable<List<GitHubRepository>>
}