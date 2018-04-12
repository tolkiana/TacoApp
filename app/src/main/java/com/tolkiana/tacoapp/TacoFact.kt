package com.tolkiana.tacoapp

import android.annotation.SuppressLint
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.android.parcel.Parcelize


@Parcelize
@SuppressLint("ParcelCreator")
@JsonIgnoreProperties(ignoreUnknown = true)
data class TacoFact(val title: String,
                   val imageURL: String,
                   val description: String) : Parcelable