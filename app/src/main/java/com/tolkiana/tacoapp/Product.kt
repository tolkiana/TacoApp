package com.tolkiana.tacoapp

import android.annotation.SuppressLint
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.android.parcel.Parcelize

/**
 * Created by tolkiana on 7/11/17.
 */
@Parcelize
@SuppressLint("ParcelCreator")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Product(val code: String,
                   val name: String,
                   val imageURL: String,
                   val ingredients: List<String>,
                   val preparation: List<String>) : Parcelable