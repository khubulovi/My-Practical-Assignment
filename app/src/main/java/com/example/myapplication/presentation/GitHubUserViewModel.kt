package com.example.myapplication.presentation

import androidx.annotation.ColorRes
import com.example.myapplication.data.user.GitHubUser

data class GitHubUserViewModel(
    val login: String,
    val name : String,
    val avatar : String,
    val type : GitHubUser.Type
) {

    @ColorRes
    val nameColor : Int=
        when(type){
            GitHubUser.Type.USER -> android.R.color.black
            GitHubUser.Type.ADMIMINISTRATOR -> android.R.color.holo_red_dark
            GitHubUser.Type.UNKHNOWN -> android.R.color.darker_gray
        }


    object Mapper{
        fun map(user:GitHubUser) =
            GitHubUserViewModel(
                user.login,
                user.name,
                user.avatar,
                user.type)
    }
}
