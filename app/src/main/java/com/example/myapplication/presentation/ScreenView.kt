package com.example.myapplication.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface ScreenView : MvpView{

    @SingleState
    fun showError(throwable: Throwable)
}