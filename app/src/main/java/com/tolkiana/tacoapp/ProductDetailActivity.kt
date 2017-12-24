package com.tolkiana.tacoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_product_detail.*

/**
 * Created by tolkiana on 12/3/17.
 */
class ProductDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.getParcelableExtra<Product>(TacoListActivity.EXTRA_PRODUCT)
        val productDetailAdapter = ProductDetailAdapter(product)
        detailRecyclerView.layoutManager = LinearLayoutManager(this)
        detailRecyclerView.adapter = productDetailAdapter
    }
}