package com.example.myapplication.presentation.user

import com.example.myapplication.data.user.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {
@SingleState
 fun showUser(user:GitHubUser)
}