package com.wadektech.androidsafebodacodingchallenge.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataX(
    @Json(name = "cmc")
    val cmc: Double,
    @Json(name = "image_uris")
    val imageUris: ImageUrisX,
    @Json(name = "legalities")
    val legalities: Legalities,
    @Json(name = "loyalty")
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
)