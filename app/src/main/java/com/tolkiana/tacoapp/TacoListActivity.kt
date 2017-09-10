package com.tolkiana.tacoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.tolkiana.tacoapp.utilities.DataParser
import kotlinx.android.synthetic.main.activity_taco_list.*

class TacoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taco_list)

        val tacoList = DataParser().parseArrayFromAsset<Product>(this.assets, "tacos.json")
        val productAdapter = ProductAdapter(tacoList)

        tacoRecyclerView.layoutManager = LinearLayoutManager(this)
        tacoRecyclerView.adapter = productAdapter
    }
}

