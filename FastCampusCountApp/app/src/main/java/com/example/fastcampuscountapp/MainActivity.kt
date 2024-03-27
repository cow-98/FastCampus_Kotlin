package com.example.fastcampuscountapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fastcampuscountapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainText.text = num.toString()

        binding.btnReset.setOnClickListener {
            num = 0
            binding.mainText.text = num.toString()
        }

        binding.btnPlus.setOnClickListener {
            num += 1
            binding.mainText.text = num.toString()
        }
    }
}