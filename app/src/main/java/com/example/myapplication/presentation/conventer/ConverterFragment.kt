package com.example.myapplication.presentation.conventer

import android.net.Uri
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment

class ConverterFragment: MvpAppCompatFragment() , ConventerView{
    override fun showContent(uri: Uri?) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun showError(throwable: Throwable) {
        TODO("Not yet implemented")
    }

    companion object{
        fun newInstance(): Fragment =
            ConverterFragment()
    }
}