package com.example.myapplication.scheduleres

import io.reactivex.rxjava3.core.Scheduler

interface Schedulers {

    fun main() : Scheduler
    fun backGround() : Scheduler
}