package com.example.fastcampusmetric

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fastcampusmetric.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

    }

}