package com.tolkiana.tacoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.tolkiana.tacoapp.services.ProductsService
import com.tolkiana.tacoapp.utilities.ApplicationImageLoader
import kotlinx.android.synthetic.main.activity_taco_list.*

class TacoListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taco_list)

        val productService = ProductsService("https://afternoon-sea-72400.herokuapp.com")
        productService.getTacosList { tacoList ->
            val productAdapter = ProductAdapter(tacoList, ApplicationImageLoader.getInstance(this))
            tacoRecyclerView.layoutManager = LinearLayoutManager(this)
            tacoRecyclerView.adapter = productAdapter
        }
    }
}

