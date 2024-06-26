package com.example.fragments.simon_fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.fragments.R
import org.w3c.dom.Text

class ClearFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_clear, container, false)

        view.findViewById<TextView>(R.id.clearTextView).setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black))

        Handler(Looper.getMainLooper()).postDelayed({
            //this portion is run when the handler is completing 2 second of delay
            view.findViewById<TextView>(R.id.clearTextView).setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.clear))
        }, 1000)
        return view
    }
}