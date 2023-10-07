package com.example.jjikmuk.ui

import android.animation.LayoutTransition
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.jjikmuk.R
import com.example.jjikmuk.util.BaseFragment
import android.content.pm.PackageManager
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.jjikmuk.databinding.FragmentHomeBinding
import com.example.jjikmuk.ui.adapter.Data
import com.example.jjikmuk.ui.adapter.RecyclerViewAdapter


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.home = this
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val item = ArrayList<Data>()
        for(i in 0 until 10){
            item.add(Data("고등어 구이"))
        }
        val adapter = RecyclerViewAdapter(item)
        binding.recyclerView.adapter = adapter
    }

    fun expandCardView(view: View){
        val transition = LayoutTransition()
        transition.enableTransitionType(LayoutTransition.CHANGING)
        transition.enableTransitionType(LayoutTransition.APPEARING)
        transition.enableTransitionType(LayoutTransition.DISAPPEARING)
        binding.layouts.layoutTransition = transition

        val v = if(binding.hidden1.visibility == View.GONE) View.VISIBLE else View.GONE
        binding.hidden1.visibility = v
        binding.hidden2.visibility = v
        binding.hidden3.visibility = v
        if(v.toString()=="0"){
            val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_fold) // 여기에 원하는 drawable 리소스 ID를 입력하세요
            binding.expandButton.text = "접기"
            binding.expandButton.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable, null)
        }else{
            val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_expand) // 여기에 원하는 drawable 리소스 ID를 입력하세요
            binding.expandButton.text = "전체 보기"
            binding.expandButton.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable, null)
        }
    }
}