package com.example.myapplication.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.repository.GitHubRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface GitHubRepositoryDao {

    @Query("SELECT * FROM `github-repository`  WHERE login LIKE :login")
    fun getRepositoriesByLogin(login: String): Observable<List<GitHubRepository>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(users: List<GitHubRepository>): Completable

}