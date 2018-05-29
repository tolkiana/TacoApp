package com.tolkiana.tacoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.tolkiana.tacoapp.services.ProductType
import com.tolkiana.tacoapp.services.TacoService
import com.tolkiana.tacoapp.utilities.ApplicationImageLoader
import kotlinx.android.synthetic.main.activity_taco_list.*

class TacoListActivity : AppCompatActivity(), ProductAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taco_list)

        title = resources.getString(R.string.famous_tacos)
        progressBar.visibility = View.VISIBLE
        TacoService.fetchProductListForProductType(ProductType.TACO) { tacoList ->
            val productAdapter = ProductAdapter(tacoList, ApplicationImageLoader.getInstance(this))
            productAdapter.onItemClickListener = this
            tacoRecyclerView.layoutManager = LinearLayoutManager(this)
            tacoRecyclerView.adapter = productAdapter
            progressBar.visibility = View.GONE
        }
    }

    override fun onItemClick(product: Product) {
        ProductDetailActivity.start(this, product)
    }
}

