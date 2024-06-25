package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SwitchFragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_switch_fragments)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var blueOn = false;
        var redOn = false;
        findViewById<Button>(R.id.red).setOnClickListener{
            redOn = true;
            val red = fragmentManager.findFragmentByTag("RedFragment")
            val blue = fragmentManager.findFragmentByTag("BlueFragment")
            supportFragmentManager.beginTransaction()
                .replace(R.id.blueFragmentLayout, RedFragment()).commit()
            println(redOn)
        }
        findViewById<Button>(R.id.blue).setOnClickListener{
            blueOn = true;
            supportFragmentManager.beginTransaction()
                .replace(R.id.redFragmentLayout, BlueFragment()).commit()
            println(blueOn)
        }
        if(blueOn) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.blueFragmentLayout, RedFragment()).commit()
            blueOn = false;
        }
        if(redOn){
            supportFragmentManager.beginTransaction()
                .replace(R.id.redFragmentLayout, BlueFragment()).commit()
            redOn = false;
        }
    }
}