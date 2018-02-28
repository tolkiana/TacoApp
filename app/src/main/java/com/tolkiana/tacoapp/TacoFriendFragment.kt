package com.tolkiana.tacoapp


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tolkiana.tacoapp.services.ProductType
import com.tolkiana.tacoapp.services.ProductsService
import com.tolkiana.tacoapp.utilities.ApplicationImageLoader
import kotlinx.android.synthetic.main.fragment_taco_friend.*


@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 */
class TacoFriendFragment(private val productType: ProductType) : Fragment(), ProductAdapter.OnItemClickListener {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_taco_friend, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tacoFriendProgressBar.visibility = View.VISIBLE
        val productService = ProductsService()
        productService.fetchProductListForProductType(productType) { drinksList ->
            val productAdapter = ProductAdapter(drinksList, ApplicationImageLoader.getInstance(context))
            productAdapter.onItemClickListener = this
            tacoFriendRecyclerView.layoutManager = LinearLayoutManager(context)
            tacoFriendRecyclerView.adapter = productAdapter
            tacoFriendProgressBar.visibility = View.GONE
        }

    }

    override fun onItemClick(product: Product) {
        ProductDetailActivity.start(context, product)
    }

}
