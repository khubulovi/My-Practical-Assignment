package com.example.myapplication.presentation.users

import com.example.myapplication.data.user.GitHubUser
import com.example.myapplication.data.user.GitHubUserRepository
import com.example.myapplication.presentation.navigation.CustomRouter
import com.example.myapplication.presentation.user.UserScreen
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository:GitHubUserRepository,
    private val router: CustomRouter
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUsers()
            .let(viewState::showUsers)
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))
}