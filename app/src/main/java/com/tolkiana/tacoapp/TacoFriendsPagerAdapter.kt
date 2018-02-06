package com.tolkiana.tacoapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by tolkiana on 2/5/18.
 */
class TacoFriendsPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SalsasFragment()
            else -> DrinksFragment()
        }
    }

    override fun getCount(): Int = 2
}