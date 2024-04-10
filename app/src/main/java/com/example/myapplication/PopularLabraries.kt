package com.example.myapplication

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class PopularLabraries : Application() {

    companion object Navigation {


        private val cicerone: Cicerone<Router> by lazy {
            Cicerone.create()
        }
        val navigationHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }
}