package com.example.thehub

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.ImageViewCompat

class MoveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_move)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val box=findViewById<ImageView>(R.id.box)

        fun moveObject(direction : String){
            when(direction){
                "up"    ->box.setY(box.getY()-50)
                "down"  ->box.setY(box.getY()+50)
                "left"  ->box.setX(box.getX()-50)
                "right" ->box.setX(box.getX()+50)
            }

            fun ImageView.setTint(@ColorRes colorRes: Int) {
                ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(ContextCompat.getColor(context, colorRes)))
            }
            when(direction){
                /*
                "up"    ->findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(Color.MAGENTA);
                "down"  ->findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(Color.GREEN);
                "left"  ->findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(Color.RED);
                "right" ->findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(Color.BLACK);
                */

                "up"    ->findViewById<ImageView>(R.id.box).setColorFilter(Color.MAGENTA);
                "down"    ->findViewById<ImageView>(R.id.box).setColorFilter(Color.MAGENTA);
                "left"    ->findViewById<ImageView>(R.id.box).setColorFilter(Color.MAGENTA);
                "right"    ->findViewById<ImageView>(R.id.box).setColorFilter(Color.MAGENTA);
            }
            findViewById<TextView>(R.id.textView2).setText("${box.getX()}")
            findViewById<TextView>(R.id.textView3).setText("${box.getY()}")

            val interestPoint = findViewById<ImageView>(R.id.interestPoint);
            if(box.getX()==645F && box.getY()==1022F){
                findViewById<TextView>(R.id.textView).setText("Encounter!!!")

                val intentNextActivity : Intent = Intent(this, FightActivity::class.java)
                startActivity(intentNextActivity)

            } else {
                findViewById<TextView>(R.id.textView).setText("Quiet")
            }
        }

        findViewById<ImageView>(R.id.up).setOnClickListener {moveObject("up")}
        findViewById<ImageView>(R.id.down).setOnClickListener {moveObject("down")}
        findViewById<ImageView>(R.id.left).setOnClickListener {moveObject("left")}
        findViewById<ImageView>(R.id.right).setOnClickListener {moveObject("right")}

    }


}