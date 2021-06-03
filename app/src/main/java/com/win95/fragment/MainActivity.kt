package com.win95.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.win95.fragment.fragments.FragmentA
import com.win95.fragment.fragments.FragmentB
import com.win95.fragment.fragments.FragmentC

class MainActivity : AppCompatActivity(),Communicator {
    private val fragmentB = FragmentB()
    private val fragmentA = FragmentA()
    private val fragmentC = FragmentC()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(fragmentA)
        val nevigationMenu = findViewById<BottomNavigationView>(R.id.nevigationMenu)
        nevigationMenu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dashbord -> replaceFragment(fragmentA)
                R.id.setting -> replaceFragment(fragmentB)
                R.id.info -> replaceFragment(fragmentC)
            }
            true
        }
    }

    override fun passData(data: String) {
        val bundle = Bundle()
        bundle.putString("message",data)
        fragmentB.arguments = bundle
        replaceFragment(fragmentB)
    }

    fun replaceFragment(fragment: Fragment){
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer,fragment)
        transaction.commit()

    }
}