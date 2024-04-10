package com.example.myapplication.presentation.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.arguments
import com.example.myapplication.data.user.GitHubUser
import com.example.myapplication.data.user.GitHubUserRepositoryFactory
import com.example.myapplication.databinding.FragmentUsersBinding
import com.example.myapplication.presentation.users.adapter.UsersAdapter
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView,
    UsersAdapter.Delegate {

    private val _binding: FragmentUsersBinding? = null
    private val binding = _binding!!
    private val usersAdapter = UsersAdapter(delagate = this)
    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GitHubUserRepositoryFactory.create(),
            router = Router()
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.users.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun onUserPicked(user: GitHubUser) {
        presenter.displayUser(user)
    }


    companion object {
        fun newInstance(): Fragment = UsersFragment()
            .arguments()
    }
}