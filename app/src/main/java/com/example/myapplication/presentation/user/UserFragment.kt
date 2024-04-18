package com.example.myapplication.presentation.user

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myapplication.R
import com.example.myapplication.arguments
import com.example.myapplication.data.repository.GitHubRepository
import com.example.myapplication.data.user.GitHubUserRepositoryFactory
import com.example.myapplication.databinding.FragmentUserDetailsBinding
import com.example.myapplication.presentation.GitHubUserViewModel
import com.example.myapplication.presentation.user.adapter.GitHubRepositoryAdapter
import com.example.myapplication.setUserAvatar
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user_details), UserView {
    private val binding: FragmentUserDetailsBinding by viewBinding()
    private val adapter = GitHubRepositoryAdapter()
    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }
    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = GitHubUserRepositoryFactory.create()
        )
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"
        fun newInstanse(userId: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to userId)
    }

    @SuppressLint("ResourceAsColor")
    override fun showUser(user: GitHubUserViewModel) {
        binding.apply {
            this.user.setUserAvatar(user.avatar)
            this.user.setTextColor(user.nameColor)
            this.user.text=user.name
        }
    }

    override fun showRepository(repository: List<GitHubRepository>) {
        binding.userRepositories.adapter=adapter
        adapter.submitList(repository)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(requireContext(), throwable.message, Toast.LENGTH_LONG).show()
    }
}