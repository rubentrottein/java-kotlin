package com.example.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fragments.simon_fragments.ClearFragment
import com.example.fragments.simon_fragments.CyanFragment
import com.example.fragments.simon_fragments.GreenFragment
import com.example.fragments.simon_fragments.PurpleFragment
import com.example.fragments.simon_fragments.YellowFragment
import kotlin.random.Random

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
        findViewById<TextView>(R.id.textView3).setOnClickListener {
            val nextActivity = Intent(this, SwitchFragments::class.java)
            startActivity(nextActivity)
        }
        findViewById<TextView>(R.id.goToSimon).setOnClickListener {
            val nextActivity = Intent(this, SimonActivity::class.java)
            startActivity(nextActivity)
        }
    }
}