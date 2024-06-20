package com.example.reto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber: EditText
    private lateinit var buttonGuess: Button
    private lateinit var textViewMessage: TextView
    private lateinit var textViewAttempts: TextView

    private var secretNumber = 0
    private var attempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextNumber)
        buttonGuess = findViewById(R.id.buttonGuess)
        textViewMessage = findViewById(R.id.textViewMessage)
        textViewAttempts = findViewById(R.id.textViewAttempts)

        resetGame()

        buttonGuess.setOnClickListener {
            val guess = editTextNumber.text.toString().toIntOrNull()
            if (guess != null) {
                checkGuess(guess)
            } else {
                textViewMessage.text = "Por favor, introduce un número válido."
            }
            editTextNumber.text.clear()
        }
    }

    private fun resetGame() {
        secretNumber = Random.nextInt(1, 101)
        attempts = 0
        textViewMessage.text = ""
        textViewAttempts.text = "Intentos: $attempts"
    }

    private fun checkGuess(guess: Int) {
        attempts++
        textViewAttempts.text = "Intentos: $attempts"

        when {
            guess < secretNumber -> {
                textViewMessage.text = "Demasiado bajo"
            }
            guess > secretNumber -> {
                textViewMessage.text = "Demasiado alto"
            }
            else -> {
                textViewMessage.text = "Adivinaste el número."
            }

        }
    }

    fun restartGame(view: View) {
        resetGame()
    }

}
