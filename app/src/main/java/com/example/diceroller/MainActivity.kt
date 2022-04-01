package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showBeginning()

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            //val resultTextView: TextView = findViewById(R.id.textView2)
            //resultTextView.text = "6"

            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //val resultTextView: TextView = findViewById(R.id.textView2)
        val diceImage: ImageView = findViewById(R.id.imageView)
        //resultTextView.text = diceRoll.toString()
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        diceImage.contentDescription = diceRoll.toString()



        val dice2 = Dice2(6)
        val diceRoll2 = dice2.roll()
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        when (diceRoll2) {
            1 -> diceImage2.setImageResource(R.drawable.dice_1)
            2 -> diceImage2.setImageResource(R.drawable.dice_2)
            3 -> diceImage2.setImageResource(R.drawable.dice_3)
            4 -> diceImage2.setImageResource(R.drawable.dice_4)
            5 -> diceImage2.setImageResource(R.drawable.dice_5)
            6 -> diceImage2.setImageResource(R.drawable.dice_6)
        }
        diceImage2.contentDescription = diceRoll2.toString()

        if(diceRoll==diceRoll2){
            Toast.makeText(this,"Selamat anda dapat dadu double!",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this,"Anda belum beruntung!",Toast.LENGTH_SHORT).show()
        }

        val resultTextView: TextView = findViewById(R.id.textView2)
        resultTextView.text = (diceRoll+diceRoll2).toString()
    }

    private fun showBeginning(){
        val diceImageStart: ImageView = findViewById(R.id.imageView)
        val diceImageStart2: ImageView = findViewById(R.id.imageView2)
        diceImageStart.setImageResource(R.drawable.empty_dice)
        diceImageStart2.setImageResource(R.drawable.empty_dice)
    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}


class Dice2(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}