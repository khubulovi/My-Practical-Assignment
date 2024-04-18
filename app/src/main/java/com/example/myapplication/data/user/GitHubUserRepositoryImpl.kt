package com.example.myapplication.data.user

import com.example.myapplication.data.repository.GitHubRepository
import com.example.myapplication.data.repository.datasourse.GitHubRepositoryCacheDataSourse
import com.example.myapplication.data.repository.datasourse.GitHubRepositoryDataSourse
import com.example.myapplication.data.user.datasourse.GitHubUserCacheDataSourse
import com.example.myapplication.data.user.datasourse.GitHubUserDataSourse
import io.reactivex.rxjava3.core.Observable

class GitHubUserRepositoryImpl(
    private val gitHubUserDataSource: GitHubUserDataSourse,
    private val gitHubUserCacheDataSource: GitHubUserCacheDataSourse,
    private val gitHubRepositoryDataSource: GitHubRepositoryDataSourse,
    private val gitHubRepositoryCacheDataSource: GitHubRepositoryCacheDataSourse,
) : GitHubUserRepository {


    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable
            .merge(
                gitHubUserCacheDataSource
                    .getUsers(),
                gitHubUserDataSource
                    .getUsers()
                    .flatMapObservable(gitHubUserCacheDataSource::retain)
            )

    override fun getUsersByLogin(userId: String): Observable<GitHubUser> =
        Observable.merge(
            gitHubUserCacheDataSource
                .getUserByLogin(userId),
            gitHubUserDataSource
                .getUserByLogin(userId)
                .flatMapCompletable { user ->
                    gitHubUserCacheDataSource
                        .retain(user)
                        .flatMapCompletable {
                            gitHubRepositoryDataSource
                                .getUserRepository(user.login)
                                .flatMapCompletable { repositories ->
                                    gitHubRepositoryCacheDataSource.retain(repositories)
                                }
                        }
                }
                .toObservable()
        )


    override fun getUserRepository(login: String): Observable<List<GitHubRepository>> =
        Observable.merge(
            gitHubRepositoryCacheDataSource.getUserRepository(login),
            gitHubRepositoryDataSource.getUserRepository(login)
                .flatMapCompletable { repositories ->
                    gitHubRepositoryCacheDataSource.retain(repositories)
                }
                .toObservable()
        )
}