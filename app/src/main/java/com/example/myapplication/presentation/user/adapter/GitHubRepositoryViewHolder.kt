package com.example.myapplication.presentation.user.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapplication.data.repository.GitHubRepository
import com.example.myapplication.databinding.UserDetailsItemBinding

class GitHubRepositoryViewHolder(view: View) : ViewHolder(view) {

    private val binding : UserDetailsItemBinding by viewBinding()

    fun bind( model : GitHubRepository){
        binding.userRepository.text=model.name
    }
}