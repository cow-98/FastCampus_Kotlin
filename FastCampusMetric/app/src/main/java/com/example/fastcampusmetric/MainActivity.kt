package com.example.fastcampusmetric

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.fastcampusmetric.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainEdt = binding.mainEdt
        val mainText = binding.mainText
        val cm = binding.cm
        val m = binding.m
        val btn = binding.mainBtn

        var inputNumber : Int = 0
        var change : Boolean = true

        mainEdt.addTextChangedListener {text ->
            inputNumber = if(text.isNullOrEmpty()) {
                0
            } else{
                text.toString().toInt()
            }

            if (change){
                mainText.text = inputNumber.times(0.01).toString()
            } else{
                mainText.text = inputNumber.times(100).toString()
            }

        }

        btn.setOnClickListener{
            change = !change
            if(change){
                m.text = "m"
                cm.text = "cm"
                mainText.text = inputNumber.times(0.01).toString()

            } else {
                m.text = "cm"
                cm.text = "m"
                mainText.text = inputNumber.times(100).toString()
            }
        }
    }
}