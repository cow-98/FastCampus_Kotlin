package com.example.emergencyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.emergencyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEdit.setOnClickListener {
            Log.d("click","ok")
            val intent = Intent(this,InputActivity::class.java)
            intent.putExtra("intent","응급의료정보")
            startActivity(intent)
            Log.e("error", "error")
        }
    }


}