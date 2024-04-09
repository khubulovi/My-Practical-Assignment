package com.example.myapplication.scheduleres

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler

class DefaultSchedulers : Schedulers {
    override fun main(): Scheduler = io.reactivex.rxjava3.schedulers.Schedulers.newThread()

    override fun backGround(): Scheduler = AndroidSchedulers.mainThread()
}