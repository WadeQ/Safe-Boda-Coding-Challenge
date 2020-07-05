package com.wadektech.androidsafebodacodingchallenge

import com.nhaarman.mockito_kotlin.whenever
import com.wadektech.androidsafebodacodingchallenge.data.Data
import com.wadektech.androidsafebodacodingchallenge.data.DataX
import com.wadektech.androidsafebodacodingchallenge.data.ImageUrisX
import com.wadektech.androidsafebodacodingchallenge.data.Legalities
import com.wadektech.androidsafebodacodingchallenge.network.MagicCardApiService
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldEqual
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TestApiService {
    private val expectedCards = listOf(
        Data(arrayListOf(DataX(1.0,"rare", ImageUrisX("small","normal"), Legalities("not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal"),
            "{U}","Field of Reality","Field of Reality","Field of Reality","Field of Reality","Field of Reality"))),
        Data(arrayListOf(DataX(1.0,"rare", ImageUrisX("small","normal"), Legalities("not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal","not_legal"),
            "{U}","Field of Reality","Field of Reality","Field of Reality","Field of Reality","Field of Reality"))))

    @Mock
    lateinit var magicCardApiService: MagicCardApiService

    @BeforeEach
    internal fun setUp() {
        MockitoAnnotations.initMocks(this)
        whenever(magicCardApiService.getAllMagicCardsAsync()).thenReturn()

    }

    @Test
    internal fun should_doSomethingWithRemoteDataFetchedWithCoroutines() {
        val actualMagicCards = runBlocking { magicCardApiService.getAllMagicCardsAsync().await() }

        actualMagicCards shouldEqual expectedCards
    }
}