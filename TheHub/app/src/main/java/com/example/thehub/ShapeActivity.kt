package com.example.thehub

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Shape
import androidx.core.content.ContextCompat
import androidx.core.graphics.rotationMatrix
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShapeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shape)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.shapeButton)

        // Set the initial background to a triangle
        button.setBackgroundResource(R.drawable.triangle_button)

        // Define a GradientDrawable for rectangle and oval
        val rectangleShape = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 16f
            setColor(ContextCompat.getColor(this@ShapeActivity, R.color.black))
        }

        val ovalShape = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(ContextCompat.getColor(this@ShapeActivity, R.color.black))
        }

        // Toggle between rectangle and oval on button click
        var isRectangle = true

        button.setOnClickListener {
            if (isRectangle) {
                button.background = ovalShape
            } else {
                button.background = rectangleShape
            }
            isRectangle = !isRectangle
        }
    }
}