package com.example.artfolio

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.artfolio.viewmodel.ArtViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private val viewModel: ArtViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setupWithNavController(navController)

        // Hide bottom nav on full screen
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.fullScreenFragment) {
                bottomNav.visibility = View.GONE
            } else {
                bottomNav.visibility = View.VISIBLE
            }
        }

        // Insert some data if empty (simple check for demo)
        // In a real app we might check shared prefs or DB count
        viewModel.insertDummyData() 
    }
}
