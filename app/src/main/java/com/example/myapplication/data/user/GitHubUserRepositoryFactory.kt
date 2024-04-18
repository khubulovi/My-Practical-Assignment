package com.example.myapplication.data.user

import android.app.usage.UsageEvents.Event.NONE
import com.example.myapplication.data.api.GitHubApiFactory
import com.example.myapplication.data.repository.datasourse.GitHubRepositoryCacheDataSourseImpl
import com.example.myapplication.data.repository.datasourse.GitHubRepositoryDataSourceImpl
import com.example.myapplication.data.storage.GitHubStorageFactory
import com.example.myapplication.data.user.datasourse.GitHubUserCacheDataSourseImpl
import com.example.myapplication.data.user.datasourse.GitHubUserDataSourseImpl

object GitHubUserRepositoryFactory {

    private val gitHubUserRepository: GitHubUserRepository by lazy(NONE) {
        GitHubUserRepositoryImpl(
            GitHubUserDataSourseImpl(
                GitHubApiFactory.create()
            ),
            GitHubUserCacheDataSourseImpl(
                GitHubStorageFactory.create()
            ),
            GitHubRepositoryDataSourceImpl(
                GitHubApiFactory.create()
            ),
            GitHubRepositoryCacheDataSourseImpl(
                GitHubStorageFactory.create()
            )
        )
    }

    fun create() : GitHubUserRepository = gitHubUserRepository
}