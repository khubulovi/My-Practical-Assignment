package com.example.myapplication.presentation.conventer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.myapplication.presentation.user.CustomFragmentScreen

object ConverterScreen : CustomFragmentScreen {
    override fun createCustomFragment(factory: FragmentFactory): Fragment =
        ConverterFragment.newInstance()
}