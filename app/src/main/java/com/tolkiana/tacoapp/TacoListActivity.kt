package com.tolkiana.tacoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_taco_list.*
import java.sql.Array
import java.util.*

class TacoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taco_list)

        val tacoList = Arrays.asList(Product("Pastor"), Product("Canasta"), Product("Asada"))
        val productAdapter = ProductAdapter(tacoList)

        tacoRecyclerView.layoutManager = LinearLayoutManager(this)
        tacoRecyclerView.adapter = productAdapter
    }
}

