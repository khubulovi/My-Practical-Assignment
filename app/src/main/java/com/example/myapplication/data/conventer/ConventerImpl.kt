package com.example.myapplication.data.conventer

import android.content.Context
import android.net.Uri
import io.reactivex.rxjava3.core.Single

class ConventerImpl(private val context: Context) : Conventer {
    override fun convert(uri: Uri): Single<Uri> =
        ConvertSingle(context, uri)
}