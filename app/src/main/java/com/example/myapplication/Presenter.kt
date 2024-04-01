package com.example.myapplication

import com.example.myapplication.databinding.ActivityMainBinding

class Presenter(
    private val view: View,
    private val model: Model,
    private val binding: ActivityMainBinding
) {

    fun counterClick(id:Int){
        when(id){
            binding.materialButton.id -> {
                val nextValue=model.next(0)
                view.setOnClickToText(0,nextValue.toString())
            }
            binding.materialButton2.id ->{
                val nextValue=model.next(1)
                view.setOnClickToText(1,nextValue.toString())
            }
            binding.materialButton3.id ->{
                val nextValue=model.next(2)
                view.setOnClickToText(2,nextValue.toString())
            }
        }
    }
}