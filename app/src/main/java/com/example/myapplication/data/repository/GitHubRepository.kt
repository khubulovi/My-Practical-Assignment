package com.example.myapplication.data.repository

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github-repository")
class GitHubRepository(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    val login: String,
    @SerializedName("name")
    val name: String
) {
    fun copy(login: String) =
        login
}