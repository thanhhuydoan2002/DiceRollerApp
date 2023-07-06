package com.example.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class Dice(){
    var sides = 6

    fun roll(): Int{
        val randomNumber = (1..6).random()
        return  randomNumber
    }
}