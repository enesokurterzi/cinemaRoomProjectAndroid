package com.enesokurterzi.cinemaroommanagerandroid

import android.app.AlertDialog
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.enesokurterzi.cinemaroommanagerandroid.databinding.RecyclerRowBinding

class SeatAdapter(private val allSeats : MutableList<MutableList<String>>, private val row: Int, private val seat: Int): RecyclerView.Adapter<SeatAdapter.SeatHolder>() {

    class SeatHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SeatHolder(binding)
    }

    override fun onBindViewHolder(holder: SeatHolder, position: Int) {
        for (row in allSeats.indices) {
            for (seat in allSeats[0].indices) {
                val chosenSeat = position % allSeats[0].size
                val chosenRow = position / allSeats[0].size
                holder.binding.recyclerViewButton.text = allSeats[row][seat]
                holder.binding.recyclerViewButton.setOnClickListener(View.OnClickListener {
                    val ticketPrice = showThePrice(chosenRow)

                    val alert = AlertDialog.Builder(it.context)
                    alert.setTitle("Buy")
                    alert.setMessage("${chosenRow+1}. Row ${chosenSeat+1}. Column price is $ticketPrice$ are you sure?")
                    alert.setPositiveButton("Yes") { _, _ ->
                        Toast.makeText(it.context, "Bought", Toast.LENGTH_LONG).show()
                        holder.binding.recyclerViewButton.text = "B"
                        holder.binding.recyclerViewButton.setBackgroundColor(Color.RED)
                    }
                    alert.setNegativeButton("No") { _, _ ->
                        Toast.makeText(it.context, "Buying canceled", Toast.LENGTH_LONG).show()
                    }
                    alert.show()
                })
            }
        }
    }

    override fun getItemCount(): Int {
        return row * seat
    }

    fun showThePrice(cRow: Int): Int{
        return if (row * seat > 40) {
            if (cRow >= row / 2) 10 else 8
        } else {
            10
        }
    }
}