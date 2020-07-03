package com.wadektech.androidsafebodacodingchallenge.data


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ImageUrisX(
    @Json(name = "normal")
    val normal: String
):Parcelable