package com.example.jjikmuk.ui

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.activityViewModels
import com.example.jjikmuk.R
import com.example.jjikmuk.databinding.ActivityCheckImageBinding
import com.example.jjikmuk.ui.adapter.ImageViewModel
import com.example.jjikmuk.util.BaseActivity

class CheckImageActivity : BaseActivity<ActivityCheckImageBinding>(R.layout.activity_check_image) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initImage()
        initFinishButton()
        initAnalyzeButton()
    }

    private fun initFinishButton(){
        binding.finishButton.setOnClickListener {
            finish()
        }
    }

    private fun initAnalyzeButton(){
        binding.analyzeButton.setOnClickListener {
            val intent = Intent(this@CheckImageActivity, LoadingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initImage(){
        val uri: Uri? = intent.getParcelableExtra("uri")
        val bitmap: Bitmap? = intent.getParcelableExtra("bitmap")
        if(uri!=null){
            binding.image.setImageURI(uri)
        }else if(bitmap!=null){
            binding.image.setImageBitmap(bitmap)
        }
    }
}