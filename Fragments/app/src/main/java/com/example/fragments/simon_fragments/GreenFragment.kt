package com.example.fragments.simon_fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.fragments.R

class GreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_green, container, false)
        val bg = view.findViewById<TextView>(R.id.green)
        var original = true
        bg.setOnClickListener {
            val finalColor = R.color.lime
            val originalColor = R.color.green
            bg.setBackgroundColor(ContextCompat.getColor(requireContext(), finalColor))

            fun playSound() {
                val resId = resources.getIdentifier("a", "raw", activity?.packageName)

                val mediaPlayer = MediaPlayer.create(activity, resId)
                mediaPlayer.start()
            }
            playSound()

            Handler(Looper.getMainLooper()).postDelayed({
                //this portion is run when the handler is completing 2 second of delay
                bg.setBackgroundColor(ContextCompat.getColor(requireContext(), originalColor))
            }, 1000)
        }
        return view
    }

}