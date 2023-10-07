package com.example.jjikmuk.ui

import android.os.Bundle
import android.view.View
import com.example.jjikmuk.R
import com.example.jjikmuk.databinding.FragmentMypageBinding
import com.example.jjikmuk.util.BaseFragment

class MypageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.setOnClickListener {

        }
    }
}