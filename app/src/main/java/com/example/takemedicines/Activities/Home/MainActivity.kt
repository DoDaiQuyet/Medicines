package com.example.takemedicines.Activities.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.takemedicines.Navigation.Navigation
import com.example.takemedicines.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navigation: Navigation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigation = Navigation(this)
        setupNavigation()
    }
    private fun setupNavigation(){
       binding.getStart.setOnClickListener{
           navigation.navigateToSignUp()
       }
    }
}