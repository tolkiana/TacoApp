package com.tolkiana.tacoapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TacoFactsPagerAdapter(private val tacoFacts:List<TacoFact>, fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager)  {

    override fun getItem(position: Int): Fragment {
        val tacoFact = tacoFacts[position]
        return TacoFactFragment.newInstance(tacoFact)
    }

    override fun getCount(): Int = tacoFacts.count()
}