package com.example.myapplication.presentation.conventer

import android.net.Uri
import com.example.myapplication.data.conventer.Conventer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class ConverterPresenter(
    private val converter: Conventer,
    private val schedulers: com.example.myapplication.scheduleres.Schedulers
) : MvpPresenter<ConventerView>() {

    private val disposable = CompositeDisposable()

    fun convert(uri: Uri) {
        viewState.showContent(uri)
        viewState.showLoading()

        disposable.add(
            converter
                .convert(uri)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.backGround())
                .subscribe(
                    viewState::showContent,
                    viewState::showError
                )
        )
    }

    fun cancel(){
        viewState.showContent(null)
        disposable.clear()
    }

    override fun onDestroy() = disposable.clear()
}