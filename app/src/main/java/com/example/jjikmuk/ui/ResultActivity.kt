package com.example.jjikmuk.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jjikmuk.R
import com.example.jjikmuk.databinding.ActivityResultBinding
import com.example.jjikmuk.util.BaseActivity

class ResultActivity : BaseActivity<ActivityResultBinding>(R.layout.activity_result) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun initHomeButton(){
        binding.homeButton.setOnClickListener {

        }
    }
}