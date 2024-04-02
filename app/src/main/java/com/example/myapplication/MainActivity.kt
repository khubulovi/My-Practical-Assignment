package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val presenter by lazy { Presenter(this, Model(), binding) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listener = android.view.View.OnClickListener { presenter.counterClick(it.id) }
        binding.apply {
            materialButton.setOnClickListener(listener)
            materialButton3.setOnClickListener(listener)
            materialButton2.setOnClickListener(listener)
        }
    }

    override fun setOnClickToText(index: Int, text: String) {
        when (index) {
            0 -> binding.materialButton.text = text
            1 -> binding.materialButton2.text = text
            2 -> binding.materialButton3.text = text
        }
    }
}