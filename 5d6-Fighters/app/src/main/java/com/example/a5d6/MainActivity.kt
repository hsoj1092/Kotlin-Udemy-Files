package com.example.a5d6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun diceClick (view:View){
        val diceSelected = view as Button

        var cellId = 0
        when(diceSelected.id){
            R.id.Dice1 -> cellId =1
            R.id.Dice2 -> cellId =2
            R.id.Dice3 -> cellId =3
            R.id.Dice4 -> cellId =4
            R.id.Dice5 -> cellId =5
        }
        timer()
        //Log.d("diceClick:", diceSelected.id.toString())
        //Log.d("CellId:", cellId.toString()
        }
    fun timer(){
        var
        for(x in 6 downTo 0){
            Thread.sleep(1000)
            }
        clock.text="6"
        }


            }

