package com.example.myapplication.presentation.user

import com.example.myapplication.data.user.GitHubUserRepository
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository
): MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUsersByLogin(userLogin)
            ?.let(viewState::showUser)
    }
}