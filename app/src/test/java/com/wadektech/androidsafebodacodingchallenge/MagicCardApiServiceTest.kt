package com.wadektech.androidsafebodacodingchallenge

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wadektech.androidsafebodacodingchallenge.network.MagicCardApiService
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MagicCardApiServiceTest {

    private var magicCardApiService: MagicCardApiService?=null
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @BeforeEach
    internal fun setUp() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.scryfall.com/cards/search?q=field+of+")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        magicCardApiService = retrofit.create(MagicCardApiService::class.java)
    }

    @Test
    internal fun should_callServiceWithCoroutine() {
        runBlocking {
            val cards = magicCardApiService?.getAllMagicCardsAsync()?.await()
            cards?.data?.forEach(::println)
        }
    }
}