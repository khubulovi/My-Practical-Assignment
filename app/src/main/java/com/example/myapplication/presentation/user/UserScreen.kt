package com.example.myapplication.presentation.user

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.myapplication.presentation.users.UsersPresenter
import com.github.terrakok.cicerone.androidx.FragmentScreen


class UserScreen(private val userLogin: String,
                 key: String?,
                 fragmentCreator: UsersPresenter
) : CustomFragmentScreen, FragmentScreen(key, fragmentCreator) {
    override fun createCustomFragment(factory: FragmentFactory): Fragment =
        UserFragment.newInstanse(userLogin)
}