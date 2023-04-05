package com.arvan.signup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val pricelist : ArrayList<rating_price> ) : RecyclerView.Adapter<MyAdapter.MyViewHolder>
    (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return  MyViewHolder(itemView)  //menampilkan item dalam list
    }

    override fun getItemCount(): Int {
        return pricelist.size //return pricelist
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = pricelist[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading //menetepkan nilai ke masing masing view
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){ //innerclass

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val tvHeading : TextView =  itemView.findViewById(R.id.tvHeading)

    }
}