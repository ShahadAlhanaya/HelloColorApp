package com.example.helloapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var hexTextView: TextView
    lateinit var coloredTextView: TextView
    lateinit var changeColorButton: Button
    lateinit var coloredBackGround: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity","The App Has Started")

        hexTextView = findViewById(R.id.HexValueTextView)
        changeColorButton = findViewById(R.id.ChangeColorButton)
        coloredTextView = findViewById(R.id.HelloTextView)
        coloredBackGround = findViewById(R.id.ColoredBackground)

        fun changeTextColor(){
            val random = Random()
            val red = random.nextInt(256)
            val green = random.nextInt(256)
            val blue = random.nextInt(256)
            var hex = String.format("#%02x%02x%02x",red,green,blue)
            coloredBackGround.setBackgroundColor(Color.parseColor(hex))
            hexTextView.text=hex.uppercase()
            if(1-(0.299*red + 0.587*green + 0.114*blue)/255>0.2){
                coloredTextView.setTextColor(resources.getColor(R.color.Concrete))
                hexTextView.setTextColor(resources.getColor(R.color.Concrete))
            }
//            coloredTextView.setTextColor(resources.getColor(R.color.Rose))
        }
        changeColorButton.setOnClickListener { changeTextColor() }


    }
}