package com.example.nasaapi.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaapi.R
import com.example.nasaapi.model.NasaTO
import com.squareup.picasso.Picasso

class ListAdapter(private val exampleList: List<NasaTO>) :
    RecyclerView.Adapter<ListAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.title.text = exampleList[position].title
        holder.explanation.text = exampleList[position].explanation
        holder.copyRight.text = exampleList[position].copyright
        holder.date.text = exampleList[position].date
        Picasso.get().load(exampleList[position].url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return exampleList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val explanation: TextView = itemView.findViewById(R.id.explanation)
        val image: ImageView = itemView.findViewById(R.id.image_view)
        val copyRight: TextView = itemView.findViewById(R.id.copyright)
        val date: TextView = itemView.findViewById(R.id.date)

    }

}