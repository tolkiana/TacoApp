package com.tolkiana.tacoapp

import android.content.res.Resources
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.tolkiana.tacoapp.services.ProductType

/**
 * Created by tolkiana on 2/5/18.
 */
class TacoFriendsPagerAdapter(private val resources: Resources, fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TacoFriendFragment.newInstance(ProductType.SALSA)
            else -> TacoFriendFragment.newInstance(ProductType.DRINK)
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> resources.getString(R.string.salsas)
            else -> resources.getString(R.string.drinks)
        }
    }
}