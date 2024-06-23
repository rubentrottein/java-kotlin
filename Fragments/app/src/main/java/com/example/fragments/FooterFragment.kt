package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class FooterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_footer, container, false)
        val footerButton = view.findViewById<Button>(R.id.footerButton)
        footerButton.setOnClickListener {
            Toast.makeText(activity, "Foot Fragment message", Toast.LENGTH_SHORT).show()
        }
        return view;
    }
}