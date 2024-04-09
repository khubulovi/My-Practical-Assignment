package com.example.myapplication.presentation

import com.example.myapplication.data.user.GitHubUser

data class GitHubUserViewModel(val login: String){

    object Mapper{
        fun map(user:GitHubUser) =
            GitHubUserViewModel(user.login.uppercase())
    }
}
