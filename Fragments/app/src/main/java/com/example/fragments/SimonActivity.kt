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

        val count = 4;
        var soundSequence : ArrayList<Int> = ArrayList()

        activateFragments(soundSequence)

        fun predef(count : Int){
            //random liste de coups d'une longueur de (count) elements
            val random = List(count) { Random.nextInt(0, 4)}
            findViewById<TextView>(R.id.number).setText(random[0].toString())
            println(random[0])
        }



        fun tourApp(level : Int) {
            when (level) {
                1 -> predef(count)
                2 -> procedure(soundSequence)
                else -> {
                    println("Erreur dans le choix du niveau!!!")
                }
            }

            tourApp(1)


        }
    }

    private fun procedure(seq: ArrayList<Int>){
        println(seq);
    }
    private fun activateFragments(soundSequence : ArrayList<Int>){
        activateFragment(R.id.frameLayout, ClearFragment(), PurpleFragment(), soundSequence)
        activateFragment(R.id.frameLayout2, ClearFragment(), CyanFragment(), soundSequence)
        activateFragment(R.id.frameLayout3, ClearFragment(), GreenFragment(), soundSequence)
        activateFragment(R.id.frameLayout4, ClearFragment(), YellowFragment(), soundSequence)
    }
    private fun activateFragment(layout : Int, endFragment : Fragment, startFragment : Fragment, soundSequence : ArrayList<Int>) {
        findViewById<FrameLayout>(layout).setOnClickListener {
            log(layout, endFragment, startFragment, soundSequence);
        }
    }

    private fun log(layout : Int, endFragment : Fragment, startFragment : Fragment, soundSequence : ArrayList<Int>): ArrayList<Int>{
        soundSequence.add(layout);
        supportFragmentManager.beginTransaction().add(layout, endFragment).commit()
        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager.beginTransaction().add(layout, startFragment).commit()
        }, 500)

        return soundSequence
    }
}