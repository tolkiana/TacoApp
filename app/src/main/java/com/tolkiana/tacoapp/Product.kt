package com.tolkiana.tacoapp

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Created by tolkiana on 7/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Product(val code: String,
                   val name: String,
                   val imageURL: String,
                   val ingredients: List<String>,
                   val preparation: List<String>)