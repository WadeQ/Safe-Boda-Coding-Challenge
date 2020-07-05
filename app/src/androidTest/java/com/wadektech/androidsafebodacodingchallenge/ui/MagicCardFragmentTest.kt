package com.wadektech.androidsafebodacodingchallenge.ui

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.wadektech.androidsafebodacodingchallenge.data.Data
import com.wadektech.androidsafebodacodingchallenge.data.DataX
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith


@MediumTest
@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
internal class MagicCardFragmentTest{

    @Test
    fun filterThroughCards() {
        val name = arrayListOf<DataX>()
        val data = Data(name)
        assertEquals(name, data.data)
    }
}