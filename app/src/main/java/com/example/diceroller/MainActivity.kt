package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollDice()
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = "Let's roll"
        rollButton.setOnClickListener{
            rollDice()
            val r: TextView = findViewById(R.id.result_text)
            Toast.makeText(this,"Rolled: ${r.text}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val random = Random.nextInt(1,7)
        resultText.text = random.toString()

        val drawbleResource = when(random){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage.setImageResource(drawbleResource)
    }
}