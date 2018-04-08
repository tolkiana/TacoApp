package com.tolkiana.tacoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_taco_facts.*

class TacoFactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taco_facts)

        tacoFactsPager.adapter = TacoFactsPagerAdapter(supportFragmentManager)
    }
}
