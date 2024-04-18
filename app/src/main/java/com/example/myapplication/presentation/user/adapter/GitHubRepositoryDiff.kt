package com.example.myapplication.presentation.user.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.data.repository.GitHubRepository

object GitHubRepositoryDiff :  DiffUtil.ItemCallback<GitHubRepository>() {
    override fun areItemsTheSame(oldItem: GitHubRepository, newItem: GitHubRepository): Boolean {
        return oldItem==newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GitHubRepository, newItem: GitHubRepository): Boolean {
        return oldItem==newItem
    }
}