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
import kotlinx.android.synthetic.main.fragment_salsas.*


/**
 * A simple [Fragment] subclass.
 */
class SalsasFragment : Fragment(), ProductAdapter.OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_salsas, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        salsasProgressBar.visibility = View.VISIBLE
        val productService = ProductsService()
        productService.getSalsasList { salsasList ->
            val productAdapter = ProductAdapter(salsasList, ApplicationImageLoader.getInstance(context))
            productAdapter.onItemClickListener = this
            salsasRecyclerView.layoutManager = LinearLayoutManager(context)
            salsasRecyclerView.adapter = productAdapter
            salsasProgressBar.visibility = View.GONE
        }
    }

    override fun onItemClick(product: Product) {
        ProductDetailActivity.start(context, product)
    }
}
