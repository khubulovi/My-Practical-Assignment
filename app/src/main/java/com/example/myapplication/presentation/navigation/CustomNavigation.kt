package com.example.myapplication.presentation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen

class CustomNavigation(activity: FragmentActivity, container: Int) :
    AppNavigator(activity, container) {

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        if (currentFragment != null) {
            fragmentTransaction
                .setCustomAnimations(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
        }
    }

    public override fun applyCommand(command: Command) {
        when (command) {
            is CustomRouter.Command -> command.execute(this)
            else -> super.applyCommand(command)
        }
    }
}