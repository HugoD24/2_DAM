package com.dam.practica01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNum1: EditText
    private lateinit var editTextNum2: EditText

    private lateinit var buttonSum: Button
    private lateinit var buttonRes: Button
    private lateinit var buttonMul: Button
    private lateinit var buttonDiv: Button

    private lateinit var textViewResult: TextView  // <- Añadido

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextNum1 = findViewById(R.id.editTextNumberDecimal)
        editTextNum2 = findViewById(R.id.editTextNumberDecimal2)

        buttonSum = findViewById(R.id.button3)
        buttonRes = findViewById(R.id.button4)
        buttonMul = findViewById(R.id.button5)
        buttonDiv = findViewById(R.id.button6)

        textViewResult = findViewById(R.id.textViewResult)  // <- Añadido

        buttonSum.setOnClickListener { calcularOperacion(Operacion.SUMA) }
        buttonRes.setOnClickListener { calcularOperacion(Operacion.RESTA) }
        buttonMul.setOnClickListener { calcularOperacion(Operacion.MULTIPLICACION) }
        buttonDiv.setOnClickListener { calcularOperacion(Operacion.DIVISION) }
    }

    private fun calcularOperacion(operacion: Operacion) {
        val num1Str = editTextNum1.text.toString()
        val num2Str = editTextNum2.text.toString()

        if (num1Str.isBlank() || num2Str.isBlank()) {
            Toast.makeText(this, "Por favor, introduce ambos números", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = num1Str.toDoubleOrNull()
        val num2 = num2Str.toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Introduce números válidos", Toast.LENGTH_SHORT).show()
            return
        }

        val resultado = when (operacion) {
            Operacion.SUMA -> num1 + num2
            Operacion.RESTA -> num1 - num2
            Operacion.MULTIPLICACION -> num1 * num2
            Operacion.DIVISION -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                    return
                } else {
                    num1 / num2
                }
            }
        }

        textViewResult.text = "Resultado: $resultado"
    }

    enum class Operacion {
        SUMA, RESTA, MULTIPLICACION, DIVISION
    }
}
