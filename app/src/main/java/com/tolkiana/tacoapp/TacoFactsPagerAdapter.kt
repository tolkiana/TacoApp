package com.tolkiana.tacoapp

import android.content.res.Resources
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TacoFactsPagerAdapter(private val resources: Resources, fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager)  {

    override fun getItem(position: Int): Fragment {
        return TacoFactFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}