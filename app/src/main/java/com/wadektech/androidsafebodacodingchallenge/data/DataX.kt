package com.wadektech.androidsafebodacodingchallenge.data


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class DataX(
    @Json(name = "cmc")
    val cmc: Double,
    @Json(name = "image_uris")
    val imageUris: ImageUrisX,
    @Json(name = "legalities")
    val legalities: Legalities,
    @Json(name = "mana_cost")
    val manaCost: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "oracle_text")
    val oracleText: String,
    @Json(name = "rarity")
    val rarity: String,
    @Json(name = "released_at")
    val releasedAt: String,
    @Json(name = "set_name")
    val setName: String,
    @Json(name = "type_line")
    val typeLine: String
):Parcelable