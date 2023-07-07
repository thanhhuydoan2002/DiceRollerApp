package com.example.dicerollerapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
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
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableR = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableR)

        val luckyNumber = 6
        if (diceRoll == luckyNumber){
            val toast = Toast.makeText(this, "You win!", Toast.LENGTH_SHORT)
            toast.show()
        }
        else{
            val toast = Toast.makeText(this, "You rolled a $diceRoll. Try again!", Toast.LENGTH_SHORT)
            toast.show()
            return
        }


    }
}
class Dice(private val numSides: Int){
    fun roll(): Int{
        return  (1..numSides).random()
    }
}
