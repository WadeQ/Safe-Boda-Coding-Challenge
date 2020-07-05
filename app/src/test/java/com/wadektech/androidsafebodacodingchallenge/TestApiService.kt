package com.wadektech.androidsafebodacodingchallenge

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.whenever
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wadektech.androidsafebodacodingchallenge.data.Data
import com.wadektech.androidsafebodacodingchallenge.data.DataX
import com.wadektech.androidsafebodacodingchallenge.data.ImageUrisX
import com.wadektech.androidsafebodacodingchallenge.data.Legalities
import com.wadektech.androidsafebodacodingchallenge.network.MagicCardApiService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.amshove.kluent.shouldEqual
import org.junit.After
import org.junit.Before
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.stubbing.OngoingStubbing
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.HttpURLConnection

class TestApiService {
    private var mockWebServer = MockWebServer()
    private var apiService: MagicCardApiService?=null
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Before
    fun setUp() {
        mockWebServer.start()

        apiService = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(MagicCardApiService::class.java)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testCompleteIntegration() = runBlocking { // that will allow to wait for coroutine
        mockWebServer.enqueue(
            MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody("""{
                    "object": "list",
                    "total_cards": 10,
                    "has_more": false,
                     "data": [{"id": "6a63e119-3b1b-4964-a4b9-b10170ff542b"}]
                }"""))

        val response = apiService?.getAllMagicCardsAsync()?.await()

        if (response != null) {
            assertEquals(0, response.data)
        }
    }
}


