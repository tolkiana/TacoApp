package com.tolkiana.tacoapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Created by tolkiana on 12/3/17.
 */
class ProductDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = getIntent().getParcelableExtra<Product>(TacoListActivity.EXTRA_PRODUCT)
        Log.d("Product", product.toString())
    }
}