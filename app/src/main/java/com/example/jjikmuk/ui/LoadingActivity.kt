package com.example.jjikmuk.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.example.jjikmuk.R

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val loadingAnimation = findViewById<LottieAnimationView>(R.id.loadingAnimation)

        loadingAnimation.postDelayed({
            loadingAnimation.pauseAnimation()
            val intent = Intent(this@LoadingActivity, ResultActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000L)
    }
}