package com.example.myapplication.presentation.user

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

interface CustomFragmentScreen {
    fun createCustomFragment(factory: FragmentFactory): Fragment
}