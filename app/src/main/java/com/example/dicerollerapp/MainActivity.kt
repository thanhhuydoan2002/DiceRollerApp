package com.example.dicerollerapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/** This activity allows roll dice and view result on the screen **/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{ rollDice() }
    }
    /** Roll the dice and update the result on the screen **/
    private fun rollDice() {
        // Create new dice with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Update the result on the screen
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}
class Dice(private val numSides: Int){
    fun roll(): Int{
        return  (1..numSides).random()
    }
}
