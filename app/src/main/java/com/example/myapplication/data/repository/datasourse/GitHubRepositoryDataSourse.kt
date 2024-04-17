package com.example.myapplication.data.repository.datasourse

import com.example.myapplication.data.repository.GitHubRepository
import io.reactivex.rxjava3.core.Single

interface GitHubRepositoryDataSourse {
    fun getUserRepository (userID : String) : Single<List<GitHubRepository>>
}