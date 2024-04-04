package com.example.myapplication.presentation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.androidx.AppNavigator

class CustomNavigator(activity: FragmentActivity, conteiner: Int) :
    AppNavigator(activity, conteiner) {

    override fun setupFragmentTransaction(
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment?
    ) {
        if (currentFragment != null) {
            fragmentTransaction
                .setCustomAnimations(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right,
                    android.R.anim.fade_in,
                    android.R.anim.overshoot_interpolator
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