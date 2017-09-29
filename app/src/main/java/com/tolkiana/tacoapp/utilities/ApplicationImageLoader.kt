package com.tolkiana.tacoapp.utilities

import android.content.Context
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley

/**
 * Created by tolkiana on 9/17/17.
 */
class ApplicationImageLoader {
    companion object {

        @Volatile private var INSTANCE: ImageLoader? = null

        fun getInstance(context: Context): ImageLoader = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildImageLoader(context.applicationContext).also { INSTANCE = it }
        }

        private fun buildImageLoader(context: Context) = ImageLoader(Volley.newRequestQueue(context), BitmapCache())
    }
}