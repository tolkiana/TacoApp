package com.tolkiana.tacoapp.utilities

import android.graphics.Bitmap
import android.util.LruCache
import com.android.volley.toolbox.ImageLoader

/**
 * Created by tolkiana on 9/10/17.
 */
class BitmapCache : LruCache<String, Bitmap>((Runtime.getRuntime().maxMemory() / 1024).toInt() / 8), ImageLoader.ImageCache {

    override fun sizeOf(key: String, value: Bitmap): Int {
        return value.rowBytes * value.height / 1024
    }

    override fun getBitmap(url: String?): Bitmap? {
        return get(url)
    }

    override fun putBitmap(url: String?, bitmap: Bitmap?) {
        put(url, bitmap)
    }
}