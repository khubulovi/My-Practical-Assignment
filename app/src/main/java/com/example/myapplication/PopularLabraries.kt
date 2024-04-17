package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.myapplication.presentation.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone


class PopularLabraries : Application() {
    @SuppressLint("StaticFieldLeak")
    object ContextHolder { lateinit var context: Context }

    companion object Navigation {

        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }

        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router

    }

    override fun onCreate() {
        super.onCreate()
        ContextHolder.context = this
    }

}