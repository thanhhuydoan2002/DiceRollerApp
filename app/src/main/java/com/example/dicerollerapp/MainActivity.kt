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
        val diceRoll2 = dice.roll()

        //Update the result on the screen
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableR1 = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableR1)

        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val drawableR2 = when(diceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage2.setImageResource(drawableR2)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()

        val total = diceRoll + diceRoll2

        val luckyNumber = 6
        if(diceRoll == diceRoll2){
            when(diceRoll){
                1->Toast.makeText(this, "You have double ones", Toast.LENGTH_SHORT).show()
                2->Toast.makeText(this, "You have double twos", Toast.LENGTH_SHORT).show()
                3->Toast.makeText(this, "You have double threes", Toast.LENGTH_SHORT).show()
                4->Toast.makeText(this, "You have double fours", Toast.LENGTH_SHORT).show()
                5->Toast.makeText(this, "You have double fives", Toast.LENGTH_SHORT).show()
                6->Toast.makeText(this, "You have double sixes", Toast.LENGTH_SHORT).show()
            }
        }
        else if (total == luckyNumber){
            Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "You rolled a $total. Try again!", Toast.LENGTH_SHORT).show()
            return
        }
    }
}
class Dice(private val numSides: Int){
    fun roll(): Int{
        return  (1..numSides).random()
    }
}
