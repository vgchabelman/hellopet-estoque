package br.com.hellopetdesign.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navHostFragment.post {
            val navController = Navigation.findNavController(this, R.id.navHostFragment)

            bottomNav?.setupWithNavController(navController)
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.productInventoryFragment,
                    R.id.materialInventoryFragment,
                    R.id.orderFragment
                )
            )
            toolbar?.setupWithNavController(navController, appBarConfiguration)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}