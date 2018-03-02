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
import java.io.Serializable


/**
 * A simple [Fragment] subclass.
 */
class TacoFriendFragment : Fragment(), ProductAdapter.OnItemClickListener {

    companion object {
        private val ARG_PRODUCT_TYPE = "productType"
        private val ARG_PRODUCT_LIST = "productList"

        fun newInstance(productType: ProductType): TacoFriendFragment {
            val arguments = Bundle()
            arguments.putSerializable(ARG_PRODUCT_TYPE, productType)
            val fragment = TacoFriendFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    private var productType: ProductType? = null
    private var products: List<Product>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_taco_friend, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            this.productType = arguments.getSerializable(ARG_PRODUCT_TYPE) as ProductType
        }
        if (savedInstanceState == null) { //This fragment is brand new
            this.productType?.let {
                fetchProductListForProductType(it)
            }
        } else { //This fragment is being recreated, maybe rotation happened.
            this.products = savedInstanceState.getSerializable(ARG_PRODUCT_LIST) as List<Product>
            this.products?.let {
                displayProductList(it)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putSerializable(ARG_PRODUCT_LIST, this.products as Serializable)
        super.onSaveInstanceState(outState)
    }

    override fun onItemClick(product: Product) {
        ProductDetailActivity.start(context, product)
    }

    private fun fetchProductListForProductType(productType: ProductType) {
        tacoFriendProgressBar.visibility = View.VISIBLE
        val productService = ProductsService()
        productService.fetchProductListForProductType(productType) { products ->
            this.products = products
            displayProductList(products)
        }
    }

    private fun displayProductList(products: List<Product>) {
        val productAdapter = ProductAdapter(products, ApplicationImageLoader.getInstance(context))
        productAdapter.onItemClickListener = this
        tacoFriendRecyclerView.layoutManager = LinearLayoutManager(context)
        tacoFriendRecyclerView.adapter = productAdapter
        tacoFriendProgressBar.visibility = View.GONE
    }
}
