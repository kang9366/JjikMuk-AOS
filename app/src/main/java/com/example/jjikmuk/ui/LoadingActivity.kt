package com.example.jjikmuk.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.airbnb.lottie.LottieAnimationView
import com.example.jjikmuk.R

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val receivedInt = intent.getIntExtra("dietId", -1)
        Log.d("testsst", receivedInt.toString())
        val intent = Intent(this@LoadingActivity, ResultActivity::class.java)
        intent.putExtra("dietId", receivedInt)

        val loadingAnimation = findViewById<LottieAnimationView>(R.id.loadingAnimation)

        loadingAnimation.postDelayed({
            loadingAnimation.pauseAnimation()
            startActivity(intent)
            finish()
        }, 3000L)
    }
}