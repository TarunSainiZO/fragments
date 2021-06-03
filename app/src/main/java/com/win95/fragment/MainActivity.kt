package com.win95.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.win95.fragment.fragments.FragmentA
import com.win95.fragment.fragments.FragmentB

class MainActivity : AppCompatActivity(),Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer,fragmentA).commit()
    }

    override fun passData(data: String) {
        val bundle = Bundle()
        bundle.putString("message",data)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentB = FragmentB()
        fragmentB.arguments = bundle

        transaction.replace(R.id.frameContainer,fragmentB).commit()
    }
}