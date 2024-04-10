package com.example.myapplication.presentation.conventer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.myapplication.presentation.user.CustomFragmentScreen
import com.github.terrakok.cicerone.Screen

object ConverterScreen : CustomFragmentScreen,Screen {
    override fun createCustomFragment(factory: FragmentFactory): Fragment =
        ConverterFragment.newInstance()
}