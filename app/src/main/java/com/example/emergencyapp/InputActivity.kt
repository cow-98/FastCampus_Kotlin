package com.example.emergencyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.emergencyapp.databinding.ActivityMainBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}