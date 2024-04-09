package com.example.myapplication.presentation.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.data.user.GitHubUser
import com.example.myapplication.presentation.users.UsersFragment

class UsersAdapter(private val delagate: UsersFragment):
    androidx.recyclerview.widget.ListAdapter<GitHubUser,UserViewHolder>(UserDiff) {

    interface Delegate {
        fun onUserPicked(user: GitHubUser)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_user,parent,false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position),delagate)
    }
}