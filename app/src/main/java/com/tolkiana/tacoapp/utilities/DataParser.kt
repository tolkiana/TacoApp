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

    inline fun <reified T> parseArrayFromAsset(assetManager: AssetManager, fileName: String): List<T> {
        val asset = assetManager.fileAsString(fileName)
        val collectionType = mapper.typeFactory.constructCollectionType(List::class.java, T::class.java)
        return mapper.readValue(asset, collectionType)
    }

    inline fun <reified T> parseObjectFromAsset(assetManager: AssetManager, fileName: String): T {
        val asset = assetManager.fileAsString(fileName)
        return mapper.readValue(asset, T::class.java)
    }

    inline fun <reified T> parseArrayFromJSON(json: String): List<T> {
        val collectionType = mapper.typeFactory.constructCollectionType(List::class.java, T::class.java)
        return mapper.readValue(json, collectionType)
    }

    fun AssetManager.fileAsString(filename: String): String {
        return open(filename).use {
            it.readBytes().toString(Charset.defaultCharset())
        }
    }
}