package com.example.myapplication.presentation.users

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.myapplication.presentation.MainActivity
import com.example.myapplication.presentation.user.CustomFragmentScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UsersScreen(
    key: String?,
    fragmentCreator: MainActivity
) : CustomFragmentScreen, FragmentScreen(key, fragmentCreator) {
    override fun createCustomFragment(factory: FragmentFactory): Fragment =
        UsersFragment.newInstance()
}