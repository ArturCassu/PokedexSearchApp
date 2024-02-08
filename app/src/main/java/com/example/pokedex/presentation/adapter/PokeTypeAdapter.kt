package com.example.pokedex.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R

class PokeTypeAdapter(private val types: List<String>): RecyclerView.Adapter<PokeTypeAdapter.PokeTypeViewHolder>(){

//    private lateinit var types: List<String>
//
//    fun setTypes(types: List<String>){
//        this.types = types
//    }
    class PokeTypeViewHolder(itemView: View): RecyclerView .ViewHolder(itemView){
        fun bind(typeImgUrl: String){
            itemView.findViewById<TextView>(R.id.textoTeste).text = typeImgUrl
//            Glide.with(itemView).load(typeImgUrl).placeholder(R.drawable.ic_launcher_foreground).into(itemView.findViewById(R.id.imageView));
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeTypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poke_type, parent, false)
        return PokeTypeViewHolder(view)
    }

    override fun getItemCount(): Int = types.size

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

}


class CustomAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.pokeTypes)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.poke_type, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
