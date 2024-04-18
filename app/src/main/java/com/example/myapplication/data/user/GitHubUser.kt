package com.example.myapplication.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName= "github_users")
data class GitHubUser(
    @PrimaryKey
    @SerializedName("id")
    val id : String,
    @ColumnInfo
    @SerializedName("name")
    val name: String,
    @ColumnInfo
    @SerializedName("login")
    val login : String,
    @ColumnInfo
    @SerializedName("avatar_ur")
    val avatar : String
) {

    @Ignore
    @SerializedName("type")
    val type:Type = Type.USER

    enum class Type {
        USER,
        ADMIMINISTRATOR,
        UNKHNOWN
    }
}