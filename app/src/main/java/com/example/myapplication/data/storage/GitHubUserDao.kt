package com.example.myapplication.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.data.user.GitHubUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM github_users")
    fun getUsers(): Observable<List<GitHubUser>>

    @Query("SELECT * FROM github_users WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Observable<GitHubUser>

    @Insert(onConflict = REPLACE)
    fun retain(users: List<GitHubUser>): Completable

    @Update(onConflict = REPLACE)
    fun retain(user: GitHubUser): Completable

}