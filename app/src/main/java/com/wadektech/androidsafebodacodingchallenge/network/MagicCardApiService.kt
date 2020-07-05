package com.wadektech.androidsafebodacodingchallenge.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wadektech.androidsafebodacodingchallenge.data.Data
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.scryfall.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface MagicCardApiService{
    @GET("/cards/search?q=field+of+")
    fun getAllMagicCardsAsync() : Deferred<Data>

    @GET("/cards/search?q=field+of+")
    fun getSingleMagicCardsAsync(@Query("q") type : String) : Deferred<Data>
}

object MagicCardApi{
    val retrofitService :MagicCardApiService by lazy {
        retrofit.create(MagicCardApiService::class.java)
    }
}