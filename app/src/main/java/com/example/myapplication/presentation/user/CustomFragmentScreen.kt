package com.example.myapplication.presentation.user

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.Screen

interface CustomFragmentScreen: Screen {
    fun createCustomFragment(factory: FragmentFactory): Fragment
}