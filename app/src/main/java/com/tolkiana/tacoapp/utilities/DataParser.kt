package com.tolkiana.tacoapp.utilities

import android.content.Context
import android.content.res.AssetManager
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.nio.charset.Charset

/**
 * Created by tolkiana on 8/21/17.
 */
object DataParser {
    val mapper = jacksonObjectMapper()

    inline fun <reified T> parseArrayFromJSON(json: String): List<T> {
        val collectionType = mapper.typeFactory.constructCollectionType(List::class.java, T::class.java)
        return mapper.readValue(json, collectionType)
    }
}