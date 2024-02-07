package com.example.pokedex.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R

class PokeTypeAdapter: RecyclerView.Adapter<PokeTypeAdapter.PokeTypeViewHolder>(){

    private lateinit var types: List<String>

    fun setTypes(types: List<String>){
        this.types = types
    }
    class PokeTypeViewHolder(itemView: View): RecyclerView .ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeTypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poke_type, parent, false)
        return PokeTypeViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PokeTypeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}