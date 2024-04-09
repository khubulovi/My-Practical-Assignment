package com.example.myapplication.presentation.users

import android.annotation.SuppressLint
import com.example.myapplication.data.user.GitHubUser
import com.example.myapplication.data.user.GitHubUserRepository
import com.example.myapplication.presentation.navigation.CustomRouter
import com.example.myapplication.presentation.user.UserScreen
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UsersView>() {

    private val disposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun onFirstViewAttach() {
        disposable.add(
            userRepository
                .getUsers()
                .subscribe(viewState::showUsers)
        )
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

    override fun destroyView(view: UsersView?) {
        super.destroyView(view)
        disposable.dispose()
    }
}