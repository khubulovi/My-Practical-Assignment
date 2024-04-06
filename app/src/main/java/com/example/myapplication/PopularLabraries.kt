package com.example.myapplication

import android.app.Application
import com.example.myapplication.presentation.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone

class PopularLabraries : Application() {

    companion object Navigation {


        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }
        val navigationHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }
}