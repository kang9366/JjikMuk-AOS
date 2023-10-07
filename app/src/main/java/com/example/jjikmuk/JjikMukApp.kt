package com.example.jjikmuk

import android.app.Application

class JjikMukApp: Application() {
    companion object {
        lateinit var preferences: PreferenceUtil
    }

    override fun onCreate() {
        super.onCreate()
        preferences = PreferenceUtil(applicationContext)
    }
}