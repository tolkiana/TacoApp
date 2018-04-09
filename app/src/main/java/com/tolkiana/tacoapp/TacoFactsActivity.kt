package com.tolkiana.tacoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tolkiana.tacoapp.services.TacoService
import kotlinx.android.synthetic.main.activity_taco_facts.*
import kotlinx.android.synthetic.main.activity_taco_list.*

class TacoFactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taco_facts)

        factsProgressBar.visibility = View.VISIBLE
        val productService = TacoService()
        productService.fetchTacoFacts { tacoFacts ->
            tacoFactsPager.adapter = TacoFactsPagerAdapter(tacoFacts, supportFragmentManager)
            factsProgressBar.visibility = View.GONE
        }
    }
}
