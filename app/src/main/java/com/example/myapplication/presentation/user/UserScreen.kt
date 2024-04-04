package com.example.myapplication.presentation.user

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.Screen


class UserScreen(private val userLogin: String
) : CustomFragmentScreen,Screen {
    override fun createCustomFragment(factory: FragmentFactory): Fragment =
        UserFragment.newInstanse(userLogin)
}