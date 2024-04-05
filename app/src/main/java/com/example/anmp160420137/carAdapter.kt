package com.example.anmp160420137

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.anmp160420137.Car

class CarAdapter(private val carList: List<Car>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.car_list_item, parent, false)
        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem = carList[position]
        holder.bind(currentItem)
        val picasso = Picasso.Builder(holder.itemView.context)
        picasso.listener { picasso, uri, exception ->
            exception.printStackTrace()
        }
        picasso.build().load(carList[position].photoUrl).into(holder.imgPhoto)
    }

    override fun getItemCount() = carList.size

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val makeTextView: TextView = itemView.findViewById(R.id.makeTextView)
        private val modelTextView: TextView = itemView.findViewById(R.id.modelTextView)
        private val yearTextView: TextView = itemView.findViewById(R.id.yearTextView)
        private val colorTextView: TextView = itemView.findViewById(R.id.colorTextView)
        //time constrant on makin Layout

        val imgPhoto:ImageView
        init { imgPhoto = view.findViewById(R.id.imgPhoto) }

        fun bind(car: Car) {
            makeTextView.text = car.make
            modelTextView.text = car.model
            yearTextView.text = car.year.toString()
            colorTextView.text = car.color
        }
    }
}
