package com.wadektech.androidsafebodacodingchallenge.viewmodels

import com.wadektech.androidsafebodacodingchallenge.data.Data
import com.wadektech.androidsafebodacodingchallenge.data.DataX
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MagicCardViewModelTest {

    @Test
    fun getNavigateToDetailsFragment() {
    }

    @Test
    fun filterThroughCards() {
        val name = arrayListOf<DataX>()
        val data = Data(name)
        assertEquals(name, data.data)
    }
}