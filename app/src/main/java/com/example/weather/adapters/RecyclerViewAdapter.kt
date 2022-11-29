package com.example.wheather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wheather.R
import com.example.wheather.data.DataItem
import com.example.wheather.databinding.RecyclerViewItemBinding
import com.squareup.picasso.Picasso

class RecyclerViewAdapter: ListAdapter<DataItem, RecyclerViewAdapter.Holder>(Comparator()) {

    class Holder(view: View): RecyclerView.ViewHolder(view){
        val binding = RecyclerViewItemBinding.bind(view)

        fun bind(item: DataItem) = with(binding){
            val tempMinMax = "${item.minTemperature}°C/${item.maxTemperature}"
            tvDateItem.text = item.time
            tvTempItem.text = item.currentTemperature.ifEmpty {tempMinMax} + "°C"
            Picasso.get().load("https:" + item.imageUrl).into(imCondItem)
        }
    }

    class Comparator: DiffUtil.ItemCallback<DataItem>() {
        override fun areItemsTheSame(
            oldItem: DataItem,
            newItem: DataItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: DataItem,
            newItem: DataItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}