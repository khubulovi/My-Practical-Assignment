package com.example.myapplication.data.api

import com.example.myapplication.data.repository.GitHubRepository
import com.example.myapplication.data.user.GitHubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubApi {

    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>

    @GET("/users{login}")
    fun fetchUserByLogin(@Path("login") login: String): Single<GitHubUser>
    @GET("/users/{login}/repos")
    fun fetchUserRepository(@Path("login") login: String): Single<List<GitHubRepository>>
}