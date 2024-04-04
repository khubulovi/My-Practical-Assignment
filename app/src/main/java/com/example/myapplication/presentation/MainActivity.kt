package com.example.myapplication.presentation

import android.content.Intent
import android.os.Bundle
import com.example.myapplication.PopularLabraries.Navigation.navigationHolder
import com.example.myapplication.PopularLabraries.Navigation.router
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.presentation.navigation.CustomNavigator
import com.example.myapplication.presentation.users.UsersScreen

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val navigator = CustomNavigator(activity = this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        router.openDeepLink(intent?.data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            router.newRootScreen(UsersScreen())
            router.openDeepLink(intent?.data)
        }
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }
}