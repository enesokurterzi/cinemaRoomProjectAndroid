package com.enesokurterzi.cinemaroommanagerandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.enesokurterzi.cinemaroommanagerandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun startButton(view: View) {
        val rowString = binding.numberOfRows.text.toString()
        val seatsString = binding.numberOfSeatsForEachRow.text.toString()

        if (rowString.isEmpty() || seatsString.isEmpty()) {
            Toast.makeText(applicationContext, "Please write the row and seat numbers.", Toast.LENGTH_LONG).show()
        }

        else if (rowString == "0" || seatsString == "0") {
            Toast.makeText(applicationContext, "Please write the row and seat numbers bigger than zero.", Toast.LENGTH_LONG).show()
        }

        else {
            val intent = Intent(applicationContext,CinemaRoom::class.java)
            intent.putExtra("row", rowString)
            intent.putExtra("seats", seatsString)
            startActivity(intent)
            finish()
        }
    }
}