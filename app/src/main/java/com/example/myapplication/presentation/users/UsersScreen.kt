package com.example.myapplication.presentation.users

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.myapplication.presentation.user.CustomFragmentScreen
import com.github.terrakok.cicerone.Screen

class UsersScreen: CustomFragmentScreen {
    override fun createCustomFragment(factory: FragmentFactory): Fragment =
        UsersFragment.newInstance()


    companion object {
        fun newInstanse(): Screen = UsersScreen()
    }
}