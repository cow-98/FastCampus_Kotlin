package com.example.emergencyapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.emergencyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

        binding.btnDelete.setOnClickListener {
            deleteData()
        }

        binding.emergencyContactlayer.setOnClickListener {
            with(Intent(Intent.ACTION_VIEW)) {
                val phoneNumber = binding.callValue.text.toString()
                    .replace("-", "")
                data = Uri.parse("tel:$phoneNumber")
                startActivity(this)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getDateUiUpdate()
    }

    private fun getDateUiUpdate() {
        with(getSharedPreferences(UserInformation, Context.MODE_PRIVATE)) {
            binding.nameValue.text = getString(Name, "미정")
            binding.birthValue.text = getString(BirthDate, "미정")
            binding.bloodValue.text = getString(BloodType, "미정")
            binding.callValue.text = getString(CautionContact, "미정")
            val caution = getString(Caution, "")

            binding.mainCaution.isVisible = caution.isNullOrEmpty().not()
            binding.cautionValue.isVisible = caution.isNullOrEmpty().not()
            if (!caution.isNullOrEmpty()) {
                binding.mainCaution.text = caution
            }
        }
    }

    private fun deleteData() {
        with(getSharedPreferences(UserInformation, MODE_PRIVATE).edit()) {
            clear()
            apply()
            getDateUiUpdate()
        }

        Toast.makeText(this, "초기화", Toast.LENGTH_SHORT).show()
    }
}