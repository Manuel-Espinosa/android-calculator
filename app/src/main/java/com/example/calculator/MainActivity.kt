package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.math.RoundingMode

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
            val num1 = number1EditText.text.toString().toFloat()
            val num2 = number2EditText.text.toString().toFloat()
            val sum = num1 + num2
            showToast("Sum is: ${formatResult(sum)}")
        } catch (e: NumberFormatException) {
            showToast("Please enter valid numbers")
        }
    }

    fun performDivision(view: View) {
        try {
            val num1 = number1EditText.text.toString().toFloat()
            val num2 = number2EditText.text.toString().toFloat()
            if (num2 == 0f) {
                showToast("Cannot divide by zero")
            } else {
                val result = num1 / num2
                showToast("Division result is: ${formatResult(result)}")
            }
        } catch (e: NumberFormatException) {
            showToast("Please enter valid numbers")
        }
    }

    private fun formatResult(result: Float): String {
        // Check if the result is an integer value
        return if (result % 1.0 == 0f) {
            result.toInt().toString()
        } else {
            // Round to 2 decimal places if the result is a float
            BigDecimal(result.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toString()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}