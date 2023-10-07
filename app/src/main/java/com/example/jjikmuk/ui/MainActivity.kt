package com.example.jjikmuk.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.os.PersistableBundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.jjikmuk.R
import com.example.jjikmuk.databinding.ActivityMainBinding
import com.example.jjikmuk.ui.adapter.ImageViewModel
import com.example.jjikmuk.ui.dialog.CameraActionListener
import com.example.jjikmuk.ui.dialog.ImageDialog
import com.example.jjikmuk.util.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    CameraActionListener {
    private lateinit var navController: NavController
    private var navState : Boolean = true
    private lateinit var dialog: ImageDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigation()
        dialog = ImageDialog(this, this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(resultCode){
            RESULT_OK -> {
//                navigateToNewFragment(CheckImageFragment())
            }
        }
    }

    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationBar.apply {
            setupWithNavController(navController)
            background = null
            menu.getItem(1).isEnabled = false
        }
        navState = true
        binding.navState = navState

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment || destination.id == R.id.mypageFragment) {
                binding.bottomAppBar.visibility = View.VISIBLE
                binding.navigationFab.visibility = View.VISIBLE

                navState = true
            } else {
                binding.bottomAppBar.visibility = View.GONE
                binding.navigationFab.visibility = View.GONE

                navState = false
            }
            binding.navState = navState
        }
        initImageButton()
    }

//    @SuppressLint("ResourceType")
//    fun navigateToNewFragment(newFragment: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//
//        transaction.apply {
//            replace(R.id., newFragment)
//            addToBackStack(null)
//            commit()
//        }
//
//    }

    private val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
        if(it != null) {
            dialog.closeDialog()
            val intent = Intent(this@MainActivity, CheckImageActivity::class.java)
            intent.putExtra("uri", it)
            startActivity(intent)
        }
    }

    private fun initImageButton() {
        binding.navigationFab.setOnClickListener {
            dialog.initDialog(pickMedia)
        }
    }

    fun requestCameraPermission() {
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) -> {
                dialog.closeDialog()
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
            dialog.closeDialog()
            initCamera()
        } else {
            // 권한을 거부한 경우
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun initCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            takePictureLauncher.launch(takePictureIntent)
        }
    }

    private val takePictureLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageBitmap = result.data?.extras?.get("data") as Bitmap
            val intent = Intent(this@MainActivity, CheckImageActivity::class.java)
            intent.putExtra("bitmap", imageBitmap)
            startActivity(intent)
        }
    }

    override fun onCameraAction() {
        requestCameraPermission()
    }
}