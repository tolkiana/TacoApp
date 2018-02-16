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
import kotlinx.android.synthetic.main.fragment_drinks.*


/**
 * A simple [Fragment] subclass.
 */
class DrinksFragment : Fragment(), ProductAdapter.OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_drinks, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        drinksProgressBar.visibility = View.VISIBLE
        val productService = ProductsService()
        productService.getDrinksList { drinksList ->
            val productAdapter = ProductAdapter(drinksList, ApplicationImageLoader.getInstance(context))
            productAdapter.onItemClickListener = this
            drinksRecyclerView.layoutManager = LinearLayoutManager(context)
            drinksRecyclerView.adapter = productAdapter
            drinksProgressBar.visibility = View.GONE
        }

    }

    override fun onItemClick(product: Product) {
        ProductDetailActivity.start(context, product)
    }

}
