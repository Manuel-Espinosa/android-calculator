package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1EditText = findViewById(R.id.number1EditText)
        number2EditText = findViewById(R.id.number2EditText)
    }

    fun performSum(view: View) {
        try {
            val num1 = number1EditText.text.toString().toInt()
            val num2 = number2EditText.text.toString().toInt()
            val sum = num1 + num2
            showToast("Sum is: $sum")
        } catch (e: NumberFormatException) {
            showToast("Please enter valid numbers")
        }
    }

    fun performDivision(view: View) {
        try {
            val num1 = number1EditText.text.toString().toInt()
            val num2 = number2EditText.text.toString().toInt()
            if (num2 == 0) {
                showToast("Cannot divide by zero")
            } else {
                val result = num1 / num2
                showToast("Division result is: $result")
            }
        } catch (e: NumberFormatException) {
            showToast("Please enter valid numbers")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
