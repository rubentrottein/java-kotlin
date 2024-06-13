package com.example.carryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        findViewById<Button>(R.id.followUp).setOnClickListener {

            val userName = findViewById<EditText>(R.id.textInput).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString()

            val intentNextActivity: Intent = Intent(this, FollowUpActivity::class.java)

            val intentErrorActivity: Intent = Intent(this, LoginErrorActivity::class.java)

            if (userName == "Test@test.fr" && password == "test") {
                println("username : " + userName + "pw : " + password)
                intentNextActivity.putExtra("name", userName)
                intentNextActivity.putExtra("password", password)
                startActivity(intentNextActivity)
            } else {
                findViewById<Button>(R.id.followUp).setOnClickListener {
                    startActivity(intentErrorActivity)
                }
            }
        }
    }
}