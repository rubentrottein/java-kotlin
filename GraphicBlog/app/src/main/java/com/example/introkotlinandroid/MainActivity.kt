package com.example.introkotlinandroid

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
        //ids textView button
        val swap = findViewById<ImageView>(R.id.imageView)

        val roll= findViewById<Button>(R.id.button)
        val dice= findViewById<ImageView>(R.id.imageView2)

        val messageTextView = findViewById<TextView>(R.id.textView)
        val messageTextView2 = findViewById<TextView>(R.id.textView2)
        val messageTextView3 = findViewById<TextView>(R.id.textView3)
        val messageTextView4 = findViewById<TextView>(R.id.textView4)

        swap.setOnClickListener(View.OnClickListener {
                val saveOne = messageTextView.text
                val save = messageTextView2.text
                messageTextView.setText(save)
                messageTextView2.setText(saveOne)
        })
        println(messageTextView)
        println(messageTextView2)


        roll.setOnClickListener(View.OnClickListener {
            val number = Random.nextInt(from=0 ,until = 6)
            val images = arrayOf(
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
                R.drawable.five,
                R.drawable.six
            )
            try{
                dice.setImageResource(images[number])
                dice.setImageResource(images[number])
                messageTextView4.setText("Image par OpenClipart-Vectors de Pixabay")
            } catch (e : Throwable ){
                dice.setImageResource(R.drawable.three)
                messageTextView3.setText(e.toString())
                messageTextView3.setText(images[number])
            }
        })

        findViewById<ImageView>(R.id.next).setOnClickListener(View.OnClickListener {
            val intentNextActivity : Intent = Intent(this, NextActivity::class.java)
            startActivity(intentNextActivity)
        })

        findViewById<ImageView>(R.id.imageButton).setOnClickListener(View.OnClickListener {
            val intentGalleryActivity : Intent = Intent(this, GalleryActivity::class.java)
            startActivity(intentGalleryActivity)
        })
    }
}