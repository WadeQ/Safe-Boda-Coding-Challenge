package com.wadektech.androidsafebodacodingchallenge.data


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Legalities(
    @Json(name = "brawl")
    val brawl: String,
    @Json(name = "commander")
    val commander: String,
    @Json(name = "duel")
    val duel: String,
    @Json(name = "future")
    val future: String,
    @Json(name = "historic")
    val historic: String,
    @Json(name = "legacy")
    val legacy: String,
    @Json(name = "modern")
    val modern: String,
    @Json(name = "oldschool")
    val oldSchool: String,
    @Json(name = "pauper")
    val pauper: String,
    @Json(name = "penny")
    val penny: String,
    @Json(name = "pioneer")
    val pioneer: String,
    @Json(name = "standard")
    val standard: String,
    @Json(name = "vintage")
    val vintage: String
): Parcelable