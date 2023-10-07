package com.example.jjikmuk.ui

import android.os.Bundle
import android.view.View
import com.example.jjikmuk.R
import com.example.jjikmuk.databinding.FragmentMypageBinding
import com.example.jjikmuk.util.BaseFragment
import com.github.mikephil.charting.data.BarEntry

class MypageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBarChart()

        binding.root.setOnClickListener {

        }
    }

    private fun setupBarChart() {
        val datas = ArrayList<BarEntry>()
        datas.add(BarEntry(1.2f,20.0f))
        datas.add(BarEntry(1.2f,20.0f))
        datas.add(BarEntry(1.2f,20.0f))
        datas.add(BarEntry(1.2f,20.0f))
        datas.add(BarEntry(1.2f,20.0f))
        datas.add(BarEntry(1.2f,20.0f))
        datas.add(BarEntry(1.2f,20.0f))


    }
}