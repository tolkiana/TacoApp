package com.tolkiana.tacoapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        famousTacosCardView.setOnClickListener {
            val intent = Intent(this, TacoListActivity::class.java)
            startActivity(intent)
        }

        tacoFriendsCardView.setOnClickListener {
            val intent = Intent(this, TacoFriendsActivity::class.java)
            startActivity(intent)
        }
    }
}
