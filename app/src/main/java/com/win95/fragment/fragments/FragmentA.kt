package com.win95.fragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.win95.fragment.Communicator
import com.win95.fragment.R


class FragmentA : Fragment() {
    private lateinit var communicator: Communicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        communicator = activity as Communicator
        val button = view.findViewById<Button>(R.id.send)
        val message = view.findViewById<EditText>(R.id.message)
        button.setOnClickListener {
            communicator.passData(message.text.toString())
            val view = getActivity()?.findViewById<BottomNavigationView>(R.id.nevigationMenu)
//            if(view!=null){
//                view.selectedItemId(getActivity()?.findViewById<View>(R.id.setting))
//            }
        }
        return view
    }
}