    package com.example.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

    class MainActivity : AppCompatActivity() {

        companion object {
            var itname:String = ""
            var itprice:Float = -1f
            var itimage:Int = -1

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val topFragment = TopFragment()
        val midFragment = MidFragment()
        val botFragment = BotFragment  ()

        fragmentTransaction.add(R.id.top_frame, topFragment)
        fragmentTransaction.add(R.id.mid_frame, midFragment)
        fragmentTransaction.add(R.id.bot_frame, botFragment)
        fragmentTransaction.commit()
//        fragmentTransaction.hide(botFragment)
//        fragmentTransaction.show(botFragment)


    }


}