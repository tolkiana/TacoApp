package com.tolkiana.tacoapp.services

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import com.tolkiana.tacoapp.Product
import com.tolkiana.tacoapp.utilities.DataParser

/**
 * Created by tolkiana on 11/10/17.
 */
class ProductsService {

    companion object {
        private const val TACO_SERVICE_URL = "https://afternoon-sea-72400.herokuapp.com"
    }

    fun fetchProductListForProductType(productType: ProductType, handler: (List<Product>) -> Unit) {
        val endpoint = TACO_SERVICE_URL + productType.path
        endpoint.httpGet().responseString { _, _, result ->
            var tacoList = listOf<Product>()
            when (result) {
                is Result.Success -> {
                    val json = result.getAs() ?: ""
                    tacoList = DataParser.parseArrayFromJSON(json)
                }
            }
            handler(tacoList)
        }
    }
}