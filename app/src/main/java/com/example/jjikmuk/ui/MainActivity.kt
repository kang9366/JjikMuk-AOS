package com.example.jjikmuk.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.jjikmuk.R
import com.example.jjikmuk.databinding.ActivityMainBinding
import com.example.jjikmuk.network.RetrofitBuilder.api
import com.example.jjikmuk.util.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var navController: NavController
    var navState : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initNavigation()
    }

    private fun initNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationBar.setupWithNavController(navController)
        binding.bottomNavigationBar.background = null
        binding.bottomNavigationBar.menu.getItem(1).isEnabled = false

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

        binding.navigationFab.setOnClickListener {
            val REQUEST_IMAGE_CAPTURE = 1

            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }

        }
    }
}