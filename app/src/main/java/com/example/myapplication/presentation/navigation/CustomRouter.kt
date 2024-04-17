package com.example.myapplication.presentation.navigation

import android.net.Uri
import com.github.terrakok.cicerone.Router

class CustomRouter : Router() {
    interface Command{
        fun execute(navigation: CustomNavigation)
    }

    fun openDeepLink(deepLink: Uri?){
        executeCommands(OpenDeepLink(deepLink))
    }
}