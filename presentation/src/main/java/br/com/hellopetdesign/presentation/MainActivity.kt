package br.com.hellopetdesign.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
//        bottomNav?.setupWithNavController(Navigation.findNavController(navHostFragment))
//        bottomNav?.inflateMenu(R.menu.activity_main)
    }
}