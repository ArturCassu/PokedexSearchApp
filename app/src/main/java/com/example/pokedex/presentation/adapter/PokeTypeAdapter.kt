package com.example.pokedex.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R

class PokeTypeAdapter(private val types: List<String>): RecyclerView.Adapter<PokeTypeAdapter.PokeTypeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeTypeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.poke_type, parent, false)
        return PokeTypeViewHolder(view)
    }
    override fun onBindViewHolder(holder: PokeTypeViewHolder, position: Int) {
        val type = types[position]
        val typeImgUrl = when(type){
            "Normal" -> {""}
            "Fire" -> {""}
            "Water" -> {""}
            "Grass" -> {""}
            "Flying" -> {""}
            "Fighting" -> {""}
            "Poison" -> {""}
            "Electric" -> {""}
            "Ground" -> {""}
            "Rock" -> {""}
            "Psychic" -> {""}
            "Ice" -> {""}
            "Bug" -> {""}
            "Ghost" -> {""}
            "Steel" -> {""}
            "Dragon" -> {""}
            "Dark" -> {""}
            "Fairy" -> {""}
            else -> {""}
        }
        holder.bind(type)
    }
    override fun getItemCount(): Int = types.size

    class PokeTypeViewHolder(itemView: View): RecyclerView .ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.imageView)
        fun bind(typeImgUrl: String){
            Log.d("RecyclerView Adapter", typeImgUrl)
            Glide.with(itemView)
                .load(typeImgUrl)
                .placeholder(R.drawable.title_image)
                .into(image);
        }
    }

}