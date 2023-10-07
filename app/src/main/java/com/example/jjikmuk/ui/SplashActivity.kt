package com.example.jjikmuk.ui

import androidx.core.content.ContextCompat.startActivity
import android.app.Activity
import android.content.Context
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log


import com.example.jjikmuk.R
import com.kakao.sdk.common.util.Utility
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity: AppCompatActivity() {
    val SPLASH_VIEW_TIME: Long = 2000L //2초간 스플래시 화면을 보여줌 (ms)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /** HashKey확인 */
        val keyHash = Utility.getKeyHash(this)
        Log.d("taag",keyHash)

        Handler().postDelayed(Runnable { //delay를 위한
            startActivity(Intent(this@SplashActivity, ViewActivity::class.java))
            finish()
        }, SPLASH_VIEW_TIME)
    }
}