package com.example.tictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {
        val buSelected = view as Button
        var cellId = 0
        when(buSelected.id){
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9
        }
        //Log.d("buClick: asdasdasd", buSelected.id.toString())
        //Log.d("buClick: cellId:",cellId.toString())
        playGame(cellId,buSelected)
    }
    var activePlayer =1

    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()

    fun playGame(cellId:Int, buSelected:Button){

        if(activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer=2
        }else{
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(cellId)
            activePlayer=1
        }
        buSelected.isEnabled = false
        checkWinner()
    }
    fun checkWinner() {
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        //row 2
        if (player1.contains(3) && player1.contains(4) && player1.contains(5)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(4) && player2.contains(5)) {
            winner = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        //column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        //column2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        //column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }
        //diagonal 1 to 9
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        // Diagonal 3 to 7
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
        if (winner == 1) {
            Toast.makeText(this, "Player 1 is the winner", Toast.LENGTH_LONG).show()
            Handler().postDelayed({
                resetGame()},
                1000
            )
        } else if (winner == 2) {
            Toast.makeText(this, "Player 2 is the winner", Toast.LENGTH_LONG).show()
            SystemClock.sleep(1000)
            resetGame()
        }
    }

        fun resetGame(){
            player1.clear()
            player2.clear()
            for(cellId in 1..9){
                var bun = when(cellId) {
                    1 -> bu1
                    2 -> bu2
                    3 -> bu3
                    4 -> bu4
                    5 -> bu5
                    6 -> bu6
                    7 -> bu7
                    8 -> bu8
                    9 -> bu9
                    else ->{bu1}
                }
                bun.text=""
                bun.setBackgroundResource(R.color.ttButtons)
                bun.isEnabled = true
            }
        }
    }


