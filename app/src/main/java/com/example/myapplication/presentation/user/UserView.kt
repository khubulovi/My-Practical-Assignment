package com.example.myapplication.presentation.user

import com.example.myapplication.data.user.GitHubUser
import com.example.myapplication.presentation.GitHubUserViewModel
import com.example.myapplication.presentation.ScreenView
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : ScreenView {
@SingleState
 fun showUser(user:GitHubUserViewModel)

}