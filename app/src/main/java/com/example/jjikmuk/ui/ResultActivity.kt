package com.example.jjikmuk.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jjikmuk.R
import com.example.jjikmuk.databinding.ActivityResultBinding
import com.example.jjikmuk.model.TestResponse
import com.example.jjikmuk.network.RetrofitBuilder
import com.example.jjikmuk.util.BaseActivity
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ResultActivity : BaseActivity<ActivityResultBinding>(R.layout.activity_result) {
    private val retrofitBuilder = RetrofitBuilder.api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dietId = intent.getIntExtra("dietId", -1)
        initData(dietId)
    }

    private fun initData(id: Int){
        retrofitBuilder.getDiet(id).enqueue(object: retrofit2.Callback<TestResponse>{
            override fun onResponse(call: Call<TestResponse>, response: Response<TestResponse>) {

            }

            override fun onFailure(call: Call<TestResponse>, t: Throwable) {
                Log.d("testttww", t.message.toString())
            }
        })
    }


    private fun initHomeButton(){
        binding.homeButton.setOnClickListener {

        }
    }
}