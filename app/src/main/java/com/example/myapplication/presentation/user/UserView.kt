package com.example.myapplication.presentation.user

import com.example.myapplication.data.repository.GitHubRepository
import com.example.myapplication.presentation.GitHubUserViewModel
import com.example.myapplication.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : ScreenView {
@SingleState
 fun showUser(user:GitHubUserViewModel)

 @SingleState
 fun showRepository(repository : List<GitHubRepository>)

}