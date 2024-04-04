package com.example.myapplication.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.click
import com.example.myapplication.data.user.GitHubUser
import com.example.myapplication.databinding.FragmentUserBinding

class UserViewHolder(view:View) : ViewHolder(view) {
    private val viewBinding: FragmentUserBinding? = null
    private val binding = viewBinding!!

    fun bind(user: GitHubUser, delegate: UsersAdapter.Delegate?) {
        with(binding) {
            binding.user.text = user.login
            root.click { delegate?.onUserPicked(user) }
        }
    }
}