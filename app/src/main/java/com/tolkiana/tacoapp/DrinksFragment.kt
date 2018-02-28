package com.tolkiana.tacoapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tolkiana.tacoapp.services.ProductsService
import com.tolkiana.tacoapp.utilities.ApplicationImageLoader


/**
 * A simple [Fragment] subclass.
 */
class DrinksFragment : Fragment(), ProductAdapter.OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentLayout = inflater?.inflate(R.layout.fragment_drinks, container, false)
        val drinksProgressBar = fragmentLayout?.findViewById(R.id.drinksProgressBar)
        val drinksRecyclerView = fragmentLayout?.findViewById(R.id.drinksRecyclerView) as RecyclerView

        drinksProgressBar?.visibility = View.VISIBLE
        val productService = ProductsService()
        productService.getDrinksList { drinksList ->
            val productAdapter = ProductAdapter(drinksList, ApplicationImageLoader.getInstance(context))
            productAdapter.onItemClickListener = this
            drinksRecyclerView.layoutManager = LinearLayoutManager(context)
            drinksRecyclerView.adapter = productAdapter
            drinksProgressBar?.visibility = View.GONE
        }

        return fragmentLayout
    }

    override fun onItemClick(product: Product) {
        ProductDetailActivity.start(context, product)
    }

}
