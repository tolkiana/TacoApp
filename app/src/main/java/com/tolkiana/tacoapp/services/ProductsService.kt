package com.tolkiana.tacoapp.services

import com.github.kittinunf.fuel.httpGet
import com.tolkiana.tacoapp.Product
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import com.tolkiana.tacoapp.utilities.DataParser

/**
 * Created by tolkiana on 11/10/17.
 */
class ProductsService(val url: String) {

    fun getTacosList(handler: (List<Product>) -> Unit) {
        productListForProductType("/tacos", handler)
    }

    fun getDrinksList(handler: (List<Product>) -> Unit) {
        productListForProductType("/drinks", handler)
    }

    fun getSalsasList(handler: (List<Product>) -> Unit) {
        productListForProductType("/salsas", handler)
    }

    private fun productListForProductType(productType: String, handler: (List<Product>) -> Unit) {
        val endpoint = url + productType
        endpoint.httpGet().responseString { request, response, result ->
            var tacoList = listOf<Product>()
            when (result) {
                is Result.Success -> {
                    val json = result.getAs() ?: ""
                    tacoList = DataParser.parseArrayFromJSON<Product>(json)
                }
            }
            handler(tacoList)
        }
    }
}