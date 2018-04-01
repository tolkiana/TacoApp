package com.tolkiana.tacoapp.services

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import com.tolkiana.tacoapp.Product
import com.tolkiana.tacoapp.TacoFact
import com.tolkiana.tacoapp.utilities.DataParser

/**
 * Created by tolkiana on 11/10/17.
 */
class TacoService {

    companion object {
        private const val TACO_SERVICE_URL = "https://afternoon-sea-72400.herokuapp.com"
    }

    fun fetchTacoFacts(handler: (List<TacoFact>) -> Unit) {
        val endpoint = TACO_SERVICE_URL + "/facts"
        endpoint.httpGet().responseString { _, _, result ->
            var tacoFacts = listOf<TacoFact>()
            when (result) {
                is Result.Success -> {
                    val json = result.getAs() ?: ""
                    tacoFacts = DataParser.parseArrayFromJSON(json)
                }
            }
            handler(tacoFacts)
        }
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