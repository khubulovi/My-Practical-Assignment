package com.example.myapplication.data.conventer

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import io.reactivex.rxjava3.android.MainThreadDisposable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.Executors

class ConvertSingle(
    private val context: Context,
    private val uri: Uri
) : Single<Uri>() {
    override fun subscribeActual(observer: SingleObserver<in Uri>) {
        val listener = ConvertListener(context, uri, observer)
        observer.onSubscribe(listener)
        listener.convert()
    }

    class ConvertListener(
        private val context: Context,
        private val uri: Uri,
        private val observer: SingleObserver<in Uri>
    ) : MainThreadDisposable(), Runnable {

        private val convertTemporary = File.createTempFile("converter", null)
        private val converterTask by lazy {
            Executors
                .newSingleThreadExecutor()
                .submit(this)
        }

        fun convert(){
            converterTask
        }

        override fun onDispose() {
            converterTask
                ?.takeIf { !isDisposed }
                ?.takeIf { task -> !task.isDone }
                ?.takeIf { task -> !task.isCancelled }
                ?.cancel(true)
                ?.also { clearConverterTemporary() }
        }

        override fun run() {
            try {
                BufferedOutputStream(FileOutputStream(convertTemporary)).use { fos ->
                    MediaStore.Images.Media
                        .getBitmap(context.contentResolver, uri)
                        .compress(Bitmap.CompressFormat.PNG, 100, fos)
                }
                converterTask
                    ?.takeIf { !isDisposed }
                    ?.takeIf { task -> task.isDone }
                    ?.takeIf { task -> task.isCancelled }
                    ?.let { observer.onSuccess(uri) }
            } catch (error: Throwable) {
                observer.onError(error)
            } finally {
                clearConverterTemporary()
            }
        }

        private fun clearConverterTemporary() {
            convertTemporary
                .takeIf(File::exists)
                .let { File::delete }
        }
    }
}