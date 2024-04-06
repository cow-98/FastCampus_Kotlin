package com.example.fastcapmpuscalculator

import android.os.Bundle
import android.telephony.AccessNetworkConstants.AccessNetworkType
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fastcapmpuscalculator.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val firstNumberText = StringBuilder("")
    private val secondNumberText = StringBuilder("")
    private val operatorText = StringBuilder("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fun numberClicked(view: View) {

        }
            val numberString = (view as? Button)?.text?.toString() ?: ""
            val numberText = if (operatorText.isEmpty()) firstNumberText else secondNumberText
            numberText.append(numberString)
            updateEquationText()
        }

        fun clearClicked(view: View) {
            firstNumberText.clear()
            secondNumberText.clear()
            operatorText.clear()
        }
        fun equalClicked(view: View) {

        }
        fun operatorClicked(view: View){
            val operatorString = (view as? Button)?.text?.toString() ?: ""

            if(firstNumberText.isEmpty()) {
                Toast.makeText(this, "숫자를 입력해주세요",Toast.LENGTH_SHORT).show()
                return
            }
            if(secondNumberText.isNotEmpty()) {
                Toast.makeText(this,"1개의 연산자만 가능합니다",Toast.LENGTH_SHORT).show()
                return
            }
            operatorText.append(operatorString)
            updateEquationText()

        }
    }

    private fun updateEquationText() {
        binding.textEquation.text = "$firstNumberText $operatorText $secondNumberText"

    }

