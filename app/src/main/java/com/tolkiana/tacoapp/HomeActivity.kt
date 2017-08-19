package com.tolkiana.tacoapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        famousTacosButton.setOnClickListener {
            val intent = Intent(this, TacoListActivity::class.java)
            startActivity(intent)
        }
    }
}
