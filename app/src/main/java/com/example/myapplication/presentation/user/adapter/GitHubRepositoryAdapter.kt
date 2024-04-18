package com.example.myapplication.presentation.user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.myapplication.R
import com.example.myapplication.data.repository.GitHubRepository

class GitHubRepositoryAdapter :
    ListAdapter<GitHubRepository, GitHubRepositoryViewHolder>(GitHubRepositoryDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubRepositoryViewHolder =
        GitHubRepositoryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.user_details_item, parent, false)
        )

    override fun onBindViewHolder(holder: GitHubRepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
