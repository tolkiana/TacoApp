package com.tolkiana.tacoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_taco_friends.*

class TacoFriendsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taco_friends)

        title = resources.getString(R.string.taco_friends)
        tacoFriendsViewPager.adapter = TacoFriendsPagerAdapter(resources, supportFragmentManager)
        tacoFriendsTabLayout.setupWithViewPager(tacoFriendsViewPager)
    }
}
