package com.tolkiana.tacoapp


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


/**
 * A simple [Fragment] subclass.
 */
class TacoFriendFragment : Fragment(), ProductAdapter.OnItemClickListener {
    private var productType: ProductType? = null

    companion object {
        fun newInstance(productType: ProductType): TacoFriendFragment{
            val fragment = TacoFriendFragment()
            fragment.productType = productType
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_taco_friend, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productType?.let {
            fetchProductListForProductType(it)
        }
    }

    override fun onItemClick(product: Product) {
        ProductDetailActivity.start(context, product)
    }

    private fun fetchProductListForProductType(productType: ProductType) {
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
}
