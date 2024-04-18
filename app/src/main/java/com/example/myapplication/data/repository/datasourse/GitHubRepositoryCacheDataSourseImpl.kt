package com.example.myapplication.data.repository.datasourse

import com.example.myapplication.data.repository.GitHubRepository
import com.example.myapplication.data.storage.GitHubStorage
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class GitHubRepositoryCacheDataSourseImpl(
    private val gitHubStorage : GitHubStorage
) : GitHubRepositoryCacheDataSourse {
    override fun getUserRepository(login: String): Observable<List<GitHubRepository>> =
        gitHubStorage
            .getGitHubRepositoryDao()
            .getRepositoriesByLogin(login)

    override fun retain(repository: List<String?>): Completable =
        gitHubStorage
            .getGitHubRepositoryDao()
            .retain(repository)
}