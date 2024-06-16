package com.example.thehub

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class GuessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_guess)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.button).setOnClickListener {

            /*Variabilisationd es éléments*/
        val computerGuess = Random.nextInt(0,10).toString();
        val userGuess = findViewById<TextInputEditText>(R.id.userGuess).text;
        val result = findViewById<TextView>(R.id.result);

            /*Controle des choix (display)*/
            findViewById<TextView>(R.id.displayGuess).setText(userGuess)
            findViewById<TextView>(R.id.displayComputerGuess).setText(computerGuess)

            /*Conditions et comportement en cas de victoire ou défaite*/
            if(computerGuess.equals(userGuess)){
                result.setText("Vous avez Gagné!")
                result.setBackgroundColor(Color.GREEN)

            } else {
                findViewById<TextView>(R.id.result).setText("Vous avez Perdu!")
                result.setBackgroundColor(Color.RED)
            }
        }
    }
}