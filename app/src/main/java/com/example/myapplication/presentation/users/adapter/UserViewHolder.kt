package com.example.myapplication.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapplication.click
import com.example.myapplication.data.user.GitHubUser
import com.example.myapplication.databinding.FragmentUserBinding

class UserViewHolder(view:View) : ViewHolder(view) {
    private val viewBinding: FragmentUserBinding by viewBinding()

    fun bind(user: GitHubUser, delegate: UsersAdapter.Delegate?) {
        with(viewBinding) {
            viewBinding.user.text = user.login
            root.click { delegate?.onUserPicked(user) }
        }
    }
}