package com.enesokurterzi.cinemaroommanagerandroid

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.enesokurterzi.cinemaroommanagerandroid.databinding.ActivityCinemaRoomBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityCinemaRoomBinding

class CinemaRoom : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCinemaRoomBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val row = intent.getStringExtra("row")!!.toInt()
        val seats = intent.getStringExtra("seats")!!.toInt()

        val allSeats = MutableList(row) {MutableList(seats) { "S" } }

        binding.recyclerViewl.layoutManager = StaggeredGridLayoutManager(seats, StaggeredGridLayoutManager.VERTICAL)
        val seatAdapter = SeatAdapter(allSeats, row, seats)
        binding.recyclerViewl.adapter = seatAdapter
    }
}