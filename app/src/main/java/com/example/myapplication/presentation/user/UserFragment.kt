package com.example.myapplication.presentation.user

import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.arguments
import com.example.myapplication.data.user.GitHubUser
import com.example.myapplication.data.user.GitHubUserRepositoryFactory
import com.example.myapplication.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView {
    private val _binding: FragmentUserBinding? = null
    private val binding = _binding!!
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

    override fun showUser(user: GitHubUser) {
        binding.user.text = user.login
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"
        fun newInstanse(userId: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to userId)
    }
}