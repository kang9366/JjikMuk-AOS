package com.example.jjikmuk.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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

        }
    }
}