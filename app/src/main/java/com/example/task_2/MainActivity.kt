package com.example.task_2

import android.os.Bundle
import android.widget.ArrayAdapter
//import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.task_2.databinding.ActivityMainBinding
//import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    val greetings = "HEY HEY HEY"
    //Экземпляр класса с заказами
    var my_orders = Orders()
    private lateinit var binding: ActivityMainBinding
//    val Log = Logger.getLogger(MainActivity::class.java.name)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //Call the static inflate() method included in the generated binding class. This creates an instance of the binding class for the activity to use.
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Pass the root view to setContentView() to make it the active view on the screen.
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val spinner: Spinner = findViewById(R.id.petrol_array)
        // Create an ArrayAdapter using the string array and a default spinner layout

    }


}