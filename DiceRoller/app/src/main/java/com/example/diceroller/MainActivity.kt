package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var imgDice : ImageView
    lateinit var imgDice2 : ImageView
    lateinit var btnRoll : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgDice = findViewById(R.id.imgRoll)
        imgDice2 = findViewById(R.id.imgRoll2)
        btnRoll = findViewById(R.id.btnRoll)

        btnRoll.setOnClickListener{ rollDice() }

    }

    private fun rollDice() {
        imgDice.setImageResource(getRandomDiceImage())
        imgDice2.setImageResource(getRandomDiceImage())
    }

    private fun getRandomDiceImage() : Int {

        var randInt = (1..6).random()

        return when (randInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

}
