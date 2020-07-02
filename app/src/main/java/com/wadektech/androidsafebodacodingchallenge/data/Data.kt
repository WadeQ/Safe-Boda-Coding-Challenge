package com.wadektech.androidsafebodacodingchallenge.data


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Data(
    @Json(name = "cmc")
    val cmc: Double,
    @Json(name = "image_uris")
    val imageUris: ImageUris,
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
    @Json(name = "set_type")
    val setType: String,
    @Json(name = "type_line")
    val typeLine: String
):Parcelable