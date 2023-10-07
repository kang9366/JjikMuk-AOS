package com.example.jjikmuk.ui

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.example.jjikmuk.R
import com.example.jjikmuk.databinding.ActivityCheckImageBinding
import com.example.jjikmuk.model.ImageResponse
import com.example.jjikmuk.network.RetrofitBuilder
import com.example.jjikmuk.util.BaseActivity
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream

class CheckImageActivity : BaseActivity<ActivityCheckImageBinding>(R.layout.activity_check_image) {
    private val retrofitBuilder = RetrofitBuilder.api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initImage()
        initFinishButton()
    }

    fun bitmapToMultipart(bitmap: Bitmap, fileName: String): MultipartBody.Part {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()

        val requestBody = byteArray.toRequestBody("image/jpeg".toMediaTypeOrNull(), 0, byteArray.size)
        return MultipartBody.Part.createFormData("image", fileName, requestBody)
    }

    private fun initFinishButton(){
        binding.finishButton.setOnClickListener {
            finish()
        }
    }

    private fun initAnalyzeButton(dietId: Int){
        binding.analyzeButton.setOnClickListener {
            val intent = Intent(this@CheckImageActivity, LoadingActivity::class.java)
            intent.putExtra("dietId", dietId)
            startActivity(intent)
        }
    }

    private fun uriToBitmap(context: Context, uri: Uri): Bitmap? {
        return context.contentResolver.openInputStream(uri)?.use { inputStream ->
            BitmapFactory.decodeStream(inputStream)
        }
    }

    private fun initImage(){
        val uri: Uri? = intent.getParcelableExtra("uri")
        val bitmap: Bitmap? = intent.getParcelableExtra("bitmap")
        if(uri!=null){
            binding.image.setImageURI(uri)
            val bitmap = uriToBitmap(this, uri)
            val multipart = bitmapToMultipart(bitmap!!, "test.jpg")
            retrofitBuilder.postImage(1, multipart).enqueue(object: Callback<ImageResponse>{
                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    Log.d("testst", response.body()!!.dietId.toString())
                    initAnalyzeButton(response.body()!!.dietId)
                }

                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                    Log.d("testst", t.message.toString())
                }
            })
        }else if(bitmap!=null){
            binding.image.setImageBitmap(bitmap)
            val multipart = bitmapToMultipart(bitmap, "test.jpg")

            retrofitBuilder.postImage(1, multipart).enqueue(object: Callback<ImageResponse>{
                override fun onResponse(
                    call: Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                    Log.d("testst", response.body()!!.dietId.toString())
                    initAnalyzeButton(response.body()!!.dietId)
                }

                override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                    Log.d("testst", t.message.toString())
                }
            })
        }
    }
}