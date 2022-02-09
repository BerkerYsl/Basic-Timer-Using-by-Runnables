package com.berkeruysal.kotlinrunabbles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var number=0
    var runnable:Runnable= Runnable {  }
    var handler:Handler= Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun start(view:View)
    {
        number=0
        runnable=object :Runnable{
            override fun run() {
                number++
                textView.text="Time: $number"
                //this runnable'a referans veriyor. burada işlemi kaç saniyede bir yapacağımızı söylüyoruz. 1 saniye
                handler.postDelayed(this,1000)
            }

        }
        //runnable başlaması için
        handler.post(runnable)
    }
    fun stop(view: View)
    {
        handler.removeCallbacks(runnable)
        number=0
        textView.text="Time: $number"
    }
}