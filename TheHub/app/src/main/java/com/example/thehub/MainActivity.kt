package com.example.thehub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
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

        findViewById<ImageView>(R.id.move).setOnClickListener {
            val intentNextActivity : Intent = Intent(this, MoveActivity::class.java)
            startActivity(intentNextActivity)
        }
        findViewById<ImageView>(R.id.shape).setOnClickListener {
            val intentNextActivity : Intent = Intent(this, ShapeActivity::class.java)
            startActivity(intentNextActivity)
        }
        findViewById<ImageView>(R.id.guess).setOnClickListener {
            val intentNextActivity : Intent = Intent(this, GuessActivity::class.java)
            startActivity(intentNextActivity)
        }
    }
}