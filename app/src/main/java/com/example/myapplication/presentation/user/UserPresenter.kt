package com.example.myapplication.presentation.user

import com.example.myapplication.presentation.GitHubUserViewModel
import com.example.myapplication.data.user.GitHubUserRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository
) : MvpPresenter<UserView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposable.add(
            userRepository
                .getUsersByLogin(userLogin)
                .map(GitHubUserViewModel.Mapper::map)
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
        )
    }

    override fun onDestroy() = disposable.clear()
}
