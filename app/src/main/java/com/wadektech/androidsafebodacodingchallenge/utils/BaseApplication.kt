package com.wadektech.androidsafebodacodingchallenge.utils

import android.app.Application
import android.os.Debug
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}