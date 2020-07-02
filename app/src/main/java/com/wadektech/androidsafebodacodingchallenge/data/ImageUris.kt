package com.wadektech.androidsafebodacodingchallenge.data


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ImageUris(
    @Json(name = "art_crop")
    val artCrop: String,
    @Json(name = "border_crop")
    val borderCrop: String,
    @Json(name = "large")
    val large: String,
    @Json(name = "normal")
    val normal: String,
    @Json(name = "png")
    val png: String,
    @Json(name = "small")
    val small: String
): Parcelable