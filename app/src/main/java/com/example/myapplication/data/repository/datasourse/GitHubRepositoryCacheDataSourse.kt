package com.example.myapplication.data.repository.datasourse

import com.example.myapplication.data.repository.GitHubRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface GitHubRepositoryCacheDataSourse {

    fun getUserRepository(login : String) : Observable<List<GitHubRepository>>
    fun retain(repository: List<GitHubRepository>) : Completable
}