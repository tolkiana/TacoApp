package com.tolkiana.tacoapp.utilities

import android.content.Context
import android.content.res.AssetManager
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.nio.charset.Charset

/**
 * Created by tolkiana on 8/21/17.
 */
class DataParser {
    val mapper = jacksonObjectMapper()

    fun <T>parseArrayFromAsset(context: Context, fileName: String, type: Class<T>) : List<T> {
        val asset = context.assets.fileAsString(fileName)
        val collectionType = mapper.typeFactory.constructCollectionType(List::class.java, type)
        return mapper.readValue(asset, collectionType)
    }

    fun <T>parseObjectFromAsset(context: Context, fileName: String, type: Class<T>): T {
        val asset = context.assets.fileAsString(fileName)
        return  mapper.readValue(asset, type)
    }

    fun AssetManager.fileAsString(filename: String) : String {
        return open(filename).use {
            it.readBytes().toString(Charset.defaultCharset())
        }
    } 
}