package com.example.myapplication.presentation.navigation

import android.net.Uri
import com.example.myapplication.presentation.user.UserScreen
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward

class OpenDeepLink(private val deepLink: Uri?) :CustomRouter.Command,Command{
    override fun execute(navigation: CustomNavigation) {
        when (deepLink?.authority) {
            "user" ->
                deepLink
                    .let(Uri::getLastPathSegment)
                    ?.let(::UserScreen)
                    ?.let { Forward(it) }
                    ?.let(navigation::applyCommand)
            else -> Unit
        }
    }
    }
