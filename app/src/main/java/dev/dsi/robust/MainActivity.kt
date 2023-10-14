package dev.dsi.robust

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dev.dsi.robust.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager
            .findFragmentById(binding.navHostFragment.id) as NavHostFragment

        navController = navHost.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fridgeFragment,
                R.id.tipsFragment,
                R.id.aboutFragment
            )
        )

        binding.toolbar.apply {
            setTitleTextColor(Color.WHITE)
            setupWithNavController(navController, appBarConfiguration)
        }

        binding.bottomNav.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}