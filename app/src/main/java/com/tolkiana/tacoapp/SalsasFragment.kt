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
class SalsasFragment : Fragment(), ProductAdapter.OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentLayout = inflater?.inflate(R.layout.fragment_salsas, container, false)
        val salsasProgressBar = fragmentLayout?.findViewById(R.id.salsasProgressBar)
        val salsasRecyclerView = fragmentLayout?.findViewById(R.id.salsasRecyclerView) as RecyclerView

        salsasProgressBar?.visibility = View.VISIBLE
        val productService = ProductsService()
        productService.getSalsasList { salsasList ->
            val productAdapter = ProductAdapter(salsasList, ApplicationImageLoader.getInstance(context))
            productAdapter.onItemClickListener = this
            salsasRecyclerView.layoutManager = LinearLayoutManager(context)
            salsasRecyclerView.adapter = productAdapter
            salsasProgressBar?.visibility = View.GONE
        }

        return fragmentLayout
    }

    override fun onItemClick(product: Product) {
        ProductDetailActivity.start(context, product)
    }
}
