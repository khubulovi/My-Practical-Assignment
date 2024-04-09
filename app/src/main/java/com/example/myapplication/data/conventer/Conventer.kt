package com.example.myapplication.data.conventer

import android.net.Uri
import io.reactivex.rxjava3.core.Single

interface Conventer {

    fun convert(uri: Uri) : Single<Uri>
}