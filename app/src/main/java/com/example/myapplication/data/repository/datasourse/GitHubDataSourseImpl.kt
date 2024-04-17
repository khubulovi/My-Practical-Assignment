package com.example.myapplication.data.repository.datasourse

import com.example.myapplication.data.api.GitHubApi
import com.example.myapplication.data.repository.GitHubRepository
import io.reactivex.rxjava3.core.Single

class GitHubRepositoryDataSourseImpl(
    private val gitHubApi: GitHubApi
) : GitHubRepositoryDataSourse {
    override fun getUserRepository(userID: String): Single<List<GitHubRepository>> =
        gitHubApi
            .fetchUserRepository(userID)
}