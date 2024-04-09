package com.example.myapplication.presentation.conventer

import android.net.Uri
import android.window.SplashScreenView
import com.example.myapplication.presentation.ScreenView
import com.github.terrakok.cicerone.Screen
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface ConventerView : ScreenView {

    @AddToEndSingle
    fun showContent(uri: Uri?)

    @AddToEndSingle
    fun showLoading()
}