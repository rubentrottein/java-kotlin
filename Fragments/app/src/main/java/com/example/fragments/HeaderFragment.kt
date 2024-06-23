package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class HeaderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_header, container, false)
        val headerButton = view.findViewById<Button>(R.id.headerButton)
        headerButton.setOnClickListener {
            Toast.makeText(activity, "Head Fragment message", Toast.LENGTH_SHORT).show()
        }

        return view;
    }
}