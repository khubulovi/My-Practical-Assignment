package com.example.myapplication.presentation.users

import com.example.myapplication.data.user.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : MvpView {
    @SingleState
    fun showUsers(users: List<GitHubUser>)
}