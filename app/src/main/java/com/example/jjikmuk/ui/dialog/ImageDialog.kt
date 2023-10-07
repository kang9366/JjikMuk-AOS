package com.example.jjikmuk.ui.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.example.jjikmuk.databinding.DialogImageBinding

interface CameraActionListener {
    fun onCameraAction()
}

class ImageDialog(private val context : Activity, private val cameraActionListener: CameraActionListener) {
    private lateinit var binding : DialogImageBinding
    private val dialog = Dialog(context)

    fun initDialog(pickMedia: ActivityResultLauncher<PickVisualMediaRequest>) {
        binding = DialogImageBinding.inflate(context.layoutInflater)
        dialog.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(binding.root)
            window?.apply {
                setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                setGravity(Gravity.BOTTOM)
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }

        binding.runGallery.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        binding.runCamera.setOnClickListener {
            cameraActionListener.onCameraAction()
            closeDialog()
        }

        dialog.show()
    }

    fun closeDialog() = dialog.dismiss()
}