package com.example.myapplication.presentation.users

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.myapplication.data.user.GitHubUser
import com.example.myapplication.data.user.GitHubUserRepository
import com.example.myapplication.presentation.navigation.CustomRouter
import com.example.myapplication.presentation.user.UserScreen
import com.github.terrakok.cicerone.androidx.Creator
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository:GitHubUserRepository,
    private val router: CustomRouter
): MvpPresenter<UsersView>(), Creator<FragmentFactory, Fragment> {

    override fun onFirstViewAttach() {
        userRepository
            .getUsers()
            .let(viewState::showUsers)
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login,"KEY", fragmentCreator = this))

    override fun create(argument: FragmentFactory): Fragment {
        TODO("Not yet implemented")
    }
}