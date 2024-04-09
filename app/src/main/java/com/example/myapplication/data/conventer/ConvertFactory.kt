package com.example.myapplication.data.conventer

import android.content.Context

object ConvertFactory {

    fun create(context: Context) : Conventer = ConventerImpl(context)
}