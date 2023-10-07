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
import com.example.jjikmuk.databinding.FragmentFirstBinding
import com.example.jjikmuk.util.BaseFragment
import android.content.pm.PackageManager


class HomeFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.home = this
    }

    fun test(view: View){
        binding?.layouts?.layoutTransition?.enableTransitionType(LayoutTransition.CHANGING)
        val v = if(binding?.details?.visibility==View.GONE) View.VISIBLE else View.GONE
        binding?.details?.visibility = v
    }

    private val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
        if(it != null) {
            // 사진을 선택한경우

        }else {
            // 사진 선택 x
        }
    }

    fun initGallery(view: View){
        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    fun requestCameraPermission(view: View) {
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA) -> {
                initCamera()
            }
            else -> {
                cameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
            }
        }
    }

    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            initCamera()
        } else {
            // 권한을 거부한 경우
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun initCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(requireActivity().packageManager) != null) {
            takePictureLauncher.launch(takePictureIntent)
        }
    }

    private val takePictureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageBitmap = result.data?.extras?.get("data") as Bitmap
        }
    }
}