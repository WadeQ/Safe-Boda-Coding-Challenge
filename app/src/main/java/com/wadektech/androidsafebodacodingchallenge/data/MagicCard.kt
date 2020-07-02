package com.wadektech.androidsafebodacodingchallenge.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MagicCard(
    @Json(name = "data")
    val `data`: List<Data>
)