package com.alex.carexpenses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.alex.carexpenses.database.RoomDB
import com.alex.carexpenses.database.RoomRepository
import com.alex.carexpenses.databinding.ActivityMainBinding
import com.alex.carexpenses.utils.APP_ACTIVITY
import com.alex.carexpenses.utils.REPOSITORY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        title = "Car Expense 2"

        APP_ACTIVITY = this

        initDatabase()
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    private fun initDatabase(){
        val dao = RoomDB.getInstance(this).getRoomDao()
        REPOSITORY = RoomRepository(dao)
    }
}