package com.example.jjikmuk.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jjikmuk.databinding.Onfragment1Binding
import com.example.jjikmuk.databinding.Onfragment2Binding
import com.example.jjikmuk.databinding.Onfragment3Binding
import com.example.jjikmuk.databinding.Onfragment4Binding

class OnFragment3 : Fragment() {
    private var _binding: Onfragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        _binding = Onfragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

}