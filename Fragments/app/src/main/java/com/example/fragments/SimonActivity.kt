package com.example.fragments

import android.content.Intent
import android.media.MediaPlayer
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

class SimonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_simon)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<TextView>(R.id.back).setOnClickListener {
            val nextActivity = Intent(this, MainActivity::class.java)
            startActivity(nextActivity)
        }

        //On associe tous les fragments et on leur donne leur listener onClick

        findViewById<FrameLayout>(R.id.frameLayout).setOnClickListener {
            findViewById<TextView>(R.id.number).setText(log(1))
        }
        findViewById<FrameLayout>(R.id.frameLayout2).setOnClickListener {
            findViewById<TextView>(R.id.number).setText(log(2))
        }
        findViewById<FrameLayout>(R.id.frameLayout3).setOnClickListener {
            findViewById<TextView>(R.id.number).setText(log(3))
        }
        findViewById<FrameLayout>(R.id.frameLayout4).setOnClickListener {
            findViewById<TextView>(R.id.number).setText(log(4))
        }

        for(i in 1..<5)
            activateFragment(i)


        /*
        fun tourApp(level: Int) {
            for(sound : soundSequence){
                log(sound)
            }
        }
        */
    }
    private var soundSequence : ArrayList<Int> = ArrayList()

    private fun activateFragment(position : Int) {

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, PurpleFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.frameLayout2, CyanFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.frameLayout3, GreenFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.frameLayout4, YellowFragment()).commit()


    }



    private fun log(position: Int): Int{
        soundSequence.add(position)
        println(soundSequence)
        println(position)
        return position
    }
}