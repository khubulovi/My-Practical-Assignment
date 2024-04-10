package com.example.myapplication.presentation.conventer

import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.click
import com.example.myapplication.data.conventer.ConvertFactory
import com.example.myapplication.databinding.FragmentConverterBinding
import com.example.myapplication.scheduleres.ScheduleresFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ConverterFragment: MvpAppCompatFragment(R.layout.fragment_converter) , ConventerView{

    private val _viewBinding : FragmentConverterBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val presenter by moxyPresenter {
        ConverterPresenter(
            converter = ConvertFactory.create(requireContext()),
            schedulers = ScheduleresFactory.create())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = "Converter"
        viewBinding.button.click ( ::pickImage )
    }

    private fun pickImage(){
        val getInt = Intent(ACTION_GET_CONTENT)
        getInt.type = "image/*"
        startActivityForResult(getInt,1)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.data?.let(presenter::convert)
            ?: Toast.makeText(requireContext(), "Image wasn't find", Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        viewBinding.progress.visibility = View.VISIBLE

        viewBinding.button.click(presenter::cancel)
        viewBinding.button.text = "Cancel"
    }

    override fun showContent(uri: Uri?) {
        val bitmap: Bitmap? = uri?.let { MediaStore.Images.Media.getBitmap(requireContext().contentResolver, uri) }

        viewBinding.progress.visibility = View.GONE
        viewBinding.imageView.setImageBitmap(bitmap)

        viewBinding.button.click(::pickImage)
        viewBinding.button.text = getString(R.string.select_image)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
    }

    companion object{
        fun newInstance(): Fragment =
            ConverterFragment()
    }
}