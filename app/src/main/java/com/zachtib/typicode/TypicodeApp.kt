package com.zachtib.typicode

import android.app.Application
import timber.log.Timber

class TypicodeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.d("TypicodeApp started")
    }
}