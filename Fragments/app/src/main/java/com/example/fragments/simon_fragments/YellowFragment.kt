package com.example.fragments.simon_fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.fragments.R
import java.util.Timer

class YellowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_yellow, container, false)
        val bg = view.findViewById<TextView>(R.id.yellow)

        bg.setOnClickListener {
            val finalColor = R.color.orange
            val originalColor = R.color.yellow
            bg.setBackgroundColor(ContextCompat.getColor(requireContext(), finalColor))

            fun playSound() {
                val resId = resources.getIdentifier("d", "raw", activity?.packageName)

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