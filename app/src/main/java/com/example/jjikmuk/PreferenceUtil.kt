package com.example.jjikmuk

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

    var isLogin: Boolean
        get() = pref.getBoolean("isLogin", false)
        set(value) = pref.edit().putBoolean("isLogin", value).apply()

    var name: String?
        get() = pref.getString("name", null)
        set(value) = pref.edit().putString("name", value).apply()
}