package com.example.emergencyapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.emergencyapp.databinding.ActivityMainBinding
import com.example.emergencyapp.databinding.InputActivityBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding: InputActivityBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InputActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bloodTypeSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.blood_type,
            android.R.layout.simple_spinner_item
        )

        binding.birthDateLayer.setOnClickListener {
            val listener = OnDateSetListener { _, year, month, dayOfMonth ->
                binding.mainBirth.text = "$year-${month.inc()}-$dayOfMonth"
            }
            DatePickerDialog(
                this,
                listener,
                1998,
                1,
                1
            ).show()
        }

        binding.cautionCheckBox.setOnCheckedChangeListener { _, isChecked ->
            binding.edtCautionValue.isVisible = isChecked
        }
        binding.edtCautionValue.isVisible = binding.cautionCheckBox.isChecked

        binding.btnSave.setOnClickListener {

            saveData()
            finish()
        }
    }

    private fun saveData() {
        with(getSharedPreferences(UserInformation, Context.MODE_PRIVATE).edit()) {
            putString(Name, binding.edtNameValue.text.toString())
            putString(CautionContact, binding.edtCallValue.text.toString())
            putString(BirthDate, binding.mainBirth.text.toString())
            putString(Caution, caution())
            putString(BloodType,getBloodType())
            apply()
        }

        Toast.makeText(this, "저장", Toast.LENGTH_SHORT).show()
    }

    private fun getBloodType(): String {
       val bloodAlphabet = binding.bloodTypeSpinner.selectedItem.toString()
        val bloodSign = if(binding.bloodTypePlus.isChecked) "+" else "-"
       return "$bloodAlphabet$bloodSign"
    }

    private fun caution():String {
      return if(binding.cautionCheckBox.isChecked) binding.edtCautionValue.text.toString() else ""
    }
}